package org.iesfm.generic.animal;

import org.iesfm.generic.Deserializer;
import org.iesfm.generic.Serializer;
import org.junit.Assert;
import org.junit.Test;

public class AnimalSerializerTest {

    @Test
    public void AnimalSerializerTests() {
        Serializer<Animal> animalSerializer = new AnimalSerializer();

        Animal animal = new Animal("Red", 4,"Dog");

        String expected = "color:Red,age:4,specie:Dog";

        String actual = animalSerializer.serialize(animal);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void animalDeserializer() {
        Deserializer<Animal> animalDeserializer = new AnimalSerializer();

        String animal ="color:Red,age:4,specie:Dog";

        Animal expected = new Animal("Red", 4, "Dog");

        Animal actual = animalDeserializer.deserialize(animal);

        Assert.assertEquals(expected, actual);
    }

}
