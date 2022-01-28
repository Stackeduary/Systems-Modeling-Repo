import unittest
from sismic.io import import_from_yaml
from sismic.interpreter import Interpreter
from sismic.testing import *


class BatteryTests(unittest.TestCase):
    def setUp(self):
        with open('laptop battery.yaml') as f:
            sc = import_from_yaml(f)

        self.battery = Interpreter(sc)
        self.battery.execute_once()

    def full_state_not_reachable(self):
        self.battery.queue('Full')
        self.battery.execute()

        self.battery.queue('Full')
        
        for step in iter(self.battery.execute_once, None):
            for event in step.sent_events:
                self.assertNotEqual(event.name, 'Full')
        
        self.assertNotIn('Full', self.battery.configuration)
    

if __name__ == "__main__":
    unittest.main()
