package org.iesfm.generic.animal;

import org.iesfm.generic.Deserializer;
import org.iesfm.generic.Serializer;

import java.util.HashMap;
import java.util.Map;

public class AnimalSerializer implements Serializer<Animal>, Deserializer<Animal> {

    final static String COLOR_FIELD = "color";
    final static String AGE_FIELD = "age";
    final static String SPECIE_FIELD = "specie";


    @Override
    public String serialize(Animal animal) {
        String colorField = COLOR_FIELD + ":" + animal.getColor();
        String ageField = AGE_FIELD + ":" + animal.getAge();
        String specieField = SPECIE_FIELD + ":" + animal.getSpecie();

        return colorField + "," + ageField + "," + specieField;
    }

    @Override
    public Animal deserialize(String value) {
        Map<String, String> animalFields = new HashMap<>();
        for (String field : value.split(",")) {
            String[] fieldValues = field.split(":");
            animalFields.put(fieldValues[0], fieldValues[1]);
        }

        String colorValue = animalFields.get(COLOR_FIELD);
        int age = Integer.parseInt(animalFields.get(AGE_FIELD));
        String specie = animalFields.get(SPECIE_FIELD);

        return new Animal(colorValue, age, specie);
    }
}
