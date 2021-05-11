package org.iesfm.xml.animals;

import org.iesfm.xml.XmlSerializer;

public class DogSerializer implements XmlSerializer<Dog> {

    @Override
    public String toXml(Dog dog) {
        //Dog (name: Rocky, age:4, color:white);
        //<dog><name>Rocky</name><age>4</age><color>white</color></dog>

        String nameElement = "<name>" + dog.getName() + "</name>";
        String ageElement = "<age>" + dog.getAge() + "</age>";
        String colorElement = "<color>" + dog.getColor() + "</color>";

        String dogElement = "<dog>" + nameElement + ageElement + colorElement + "</dog>";

        return dogElement;
    }
}
