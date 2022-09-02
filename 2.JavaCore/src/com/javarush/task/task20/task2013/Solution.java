package com.javarush.task.task20.task2013;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Externalizable Person
*/

public class Solution
{
    public static class Person implements Externalizable, Serializable
    {
        private String firstName;
        private String lastName;
        private int age;
        private Person mother;
        private Person father;
        private List<Person> children;

        public Person()
        {
        }

        public Person(String firstName, String lastName, int age)
        {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public void setMother(Person mother)
        {
            this.mother = mother;
        }

        public void setFather(Person father)
        {
            this.father = father;
        }

        public void setChildren(List<Person> children)
        {
            this.children = children;
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException
        {
            out.writeObject(firstName);
            out.writeObject(lastName);
            out.writeObject(father);
            out.writeObject(mother);
            out.writeInt(age);
            out.writeObject(children);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException
        {
            firstName = (String) in.readObject();
            lastName = (String) in.readObject();
            father = (Person) in.readObject();
            mother = (Person) in.readObject();
            age = in.readInt();
            children = (List<Person>) in.readObject();
        }

        @Override
        public boolean equals(Object o)
        {
            if (this == o) return true;
            if (!(o instanceof Person)) return false;

            Person person = (Person) o;

            if (age != person.age) return false;
            if (!firstName.equals(person.firstName)) return false;
            if (!lastName.equals(person.lastName)) return false;
            if (mother != null ? !mother.equals(person.mother) : person.mother != null) return false;
            if (father != null ? !father.equals(person.father) : person.father != null) return false;

            int amount1;
            if (children == null) amount1 = -1;
            else amount1 = children.size();

            int amount2;
            if (person.children == null) amount2 = -1;
            else amount2 = person.children.size();

            if (amount1 != amount2) return false;
            if (amount1 > 0 && amount2 > 0)
            {
                for (int i = 0; i < amount1; i++)
                {
                    if (!children.get(i).equals(person.children.get(i))) return false;
                }
            }
            return true;
        }

        @Override
        public int hashCode()
        {
            int result = firstName.hashCode();
            result = 31 * result + lastName.hashCode();
            result = 31 * result + age;
            result = 31 * result + (mother != null ? mother.hashCode() : 0);
            result = 31 * result + (father != null ? father.hashCode() : 0);
            if (children == null) return 31 * result;
            for (Person child : children)
            {
                result = 31 * result + child.hashCode();
            }
            return result;
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        Person andrey = new Person("Andrey", "Ivanov", 32);
        andrey.father = new Person("Father`sFirstName", "Father`sLastName", 49);
        andrey.mother = new Person("Mother'sFirstName", "Mother`sLastName", 45);
        andrey.children = new ArrayList<>();
        andrey.children.add(new Person("Son`sFirstName", "Son`sLastName", 3));
        andrey.children.add(new Person("Douther`sFirstName", "Douther`sLastName", 13));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        andrey.writeExternal(objectOutputStream);

        ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        Person andreyCopy = new Person();
        andreyCopy.readExternal(objectInputStream);

        System.out.println(andrey.equals(andreyCopy));
    }
}
