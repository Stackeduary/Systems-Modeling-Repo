package org.mancala2;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Collections;
import java.util.Collection;
import java.beans.PropertyChangeSupport;

public class Person
{
   public static final String PROPERTY_NAME = "name";
   public static final String PROPERTY_STORE = "store";
   public static final String PROPERTY_HOUSES = "houses";
   private String name;
   private Store store;
   private List<House> houses;
   protected PropertyChangeSupport listeners;

   public String getName()
   {
      return this.name;
   }

   public Person setName(String value)
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

   public Store getStore()
   {
      return this.store;
   }

   public Person setStore(Store value)
   {
      if (this.store == value)
      {
         return this;
      }

      final Store oldValue = this.store;
      this.store = value;
      this.firePropertyChange(PROPERTY_STORE, oldValue, value);
      return this;
   }

   public List<House> getHouses()
   {
      return this.houses != null ? Collections.unmodifiableList(this.houses) : Collections.emptyList();
   }

   public Person withHouses(House value)
   {
      if (this.houses == null)
      {
         this.houses = new ArrayList<>();
      }
      if (!this.houses.contains(value))
      {
         this.houses.add(value);
         this.firePropertyChange(PROPERTY_HOUSES, null, value);
      }
      return this;
   }

   public Person withHouses(House... value)
   {
      for (final House item : value)
      {
         this.withHouses(item);
      }
      return this;
   }

   public Person withHouses(Collection<? extends House> value)
   {
      for (final House item : value)
      {
         this.withHouses(item);
      }
      return this;
   }

   public Person withoutHouses(House value)
   {
      if (this.houses != null && this.houses.remove(value))
      {
         this.firePropertyChange(PROPERTY_HOUSES, value, null);
      }
      return this;
   }

   public Person withoutHouses(House... value)
   {
      for (final House item : value)
      {
         this.withoutHouses(item);
      }
      return this;
   }

   public Person withoutHouses(Collection<? extends House> value)
   {
      for (final House item : value)
      {
         this.withoutHouses(item);
      }
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

   public void removeYou()
   {
      this.setStore(null);
      this.withoutHouses(new ArrayList<>(this.getHouses()));
   }
}
