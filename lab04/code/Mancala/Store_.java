package org.mancala2;
import java.util.Objects;
import java.beans.PropertyChangeSupport;

public class Store
{
   public static final String PROPERTY_NAME = "name";
   public static final String PROPERTY_PEBBLES = "pebbles";
   private String name;
   private int pebbles;
   protected PropertyChangeSupport listeners;

   public String getName()
   {
      return this.name;
   }

   public Store setName(String value)
   {
      if (Objects.equals(value, this.name))
      {
         return this;
      }

      final String oldValue = this.name;
      this.name = value;
      this.firePropertyChange(PROPERTY_NAME, oldValue, value);
      return this;
   }

   public int getPebbles()
   {
      return this.pebbles;
   }

   public Store setPebbles(int value)
   {
      if (value == this.pebbles)
      {
         return this;
      }

      final int oldValue = this.pebbles;
      this.pebbles = value;
      this.firePropertyChange(PROPERTY_PEBBLES, oldValue, value);
      return this;
   }

   public boolean firePropertyChange(String propertyName, Object oldValue, Object newValue)
   {
      if (this.listeners != null)
      {
         this.listeners.firePropertyChange(propertyName, oldValue, newValue);
         return true;
      }
      return false;
   }

   public PropertyChangeSupport listeners()
   {
      if (this.listeners == null)
      {
         this.listeners = new PropertyChangeSupport(this);
      }
      return this.listeners;
   }

   @Override
   public String toString()
   {
      final StringBuilder result = new StringBuilder();
      result.append(' ').append(this.getName());
      return result.substring(1);
   }
}
