from sismic.io import import_from_yaml, export_to_plantuml
from sismic.interpreter import Interpreter
import networkx as nx
import matplotlib.pyplot as plt
import copy

def reachability_recurse(state_graph, state_machine, interpreter_stack, visited_states, test_transitions = None):
    interpreter = interpreter_stack[-1]  # get top interpreter
    current_state = interpreter.configuration[1]  # get state TODO: consider here if you have several states when moving to concurrency
    # check all outgoing transitions for that interpreter
    transitions = test_transitions
    if transitions is None:
        transitions = [t.event for t in state_machine.transitions_from(current_state)]
    for transition in transitions:
        # execute this transition on the current interpreter copy to be able to backtrack
        interpreter_copy = copy.deepcopy(interpreter)
        interpreter_copy.queue(transition)
        macro_step = interpreter_copy.execute_once()  # We know that we can execute these
        # copy.deepcopy(interpreter).execute_once().entered_states
        if len(macro_step.entered_states) > 0:
            new_state =  interpreter_copy.configuration[1]
            state_graph.add_edge(current_state, new_state, edge=transition)
            print(f"Following edge: {current_state}, {new_state} - {transition}")
            # check if we found an unvisited state
            if new_state not in visited_states:  # already know that one
                visited_states.add(new_state)
                interpreter_stack.append(interpreter_copy)
                reachability_recurse(state_graph, state_machine, interpreter_stack, visited_states, test_transitions)
                del(interpreter_stack[-1])
                visited_states.remove(new_state)

def reachability(state_machine, transitions=None):
    """
    Go through/follow all states and respective transitions.
    :param state_machine: the state machine for which to build the reachability graph
    :param transitions: list of transitions to check (or None -> derives efficient state based transitions)
    :return:
    """
    state_graph = nx.DiGraph()
    # Create an interpreter for this statechart
    interpreter = Interpreter(state_machine)
    interpreter.execute_once()  # bring to default state

    interpreter_stack = [interpreter]
    visited_states = set()
    if transitions is not None:
        transitions = set(transitions)  # avoid duplicates
    reachability_recurse(state_graph, state_machine, interpreter_stack, visited_states, transitions)
    return state_graph

def show(state_graph):
    """
    Draw the networkx graph given in state_graph with matplotlib.
    :param state_graph:
    :return:
    """
    pos = nx.planar_layout(state_graph)
    plt.figure()
    nx.draw(state_graph, pos, node_size=2000, with_labels=True, )
    edge_labels = nx.get_edge_attributes(state_graph, 'edge')  # same key as given in labeling
    formatted_edge_labels = {(elem[0], elem[1]): edge_labels[elem] for elem in edge_labels}
    nx.draw_networkx_edge_labels(state_graph, pos, edge_labels=formatted_edge_labels)
    plt.show()


def check_no_way_to_initial(state_graph):
    """
    Check if every state can go back to the initial state.
    :param state_graph:
    :return: list of states that don't return to the initial/firs state
    """
    first = None
    result = []
    for node in state_graph:
        if first is None:
            first = node
        else:
            if not nx.algorithms.shortest_paths.has_path(state_graph, node, first):
                result.append(node)
    return result


def main():
    # Load statechart from yaml file
    # state_chart = import_from_yaml(filepath="laptop_power_management.yaml")
    state_chart = import_from_yaml(filepath="laptop battery.yaml")
    # export something that we can visualize
    export_to_plantuml(state_chart, filepath = "statechart-debug.plantuml")
    transitions = set([t.event for t in state_chart.transitions])  # set to avoid duplicates
    #  or efficient when skipping using transistions (transistions = None)
#    state_graph = reachability(state_chart, transitions)  # blackbox test reachability
#    print("These nodes will never come back to initial: ", ", ".join(check_no_way_to_initial(state_graph)))
#    show(state_graph)
    state_graph = reachability(state_chart, transitions)  # blackbox test reachability
    print("These nodes will never come back to initial: ", ", ".join(check_no_way_to_initial(state_graph)))
    show(state_graph)


if __name__ == '__main__':
    main()