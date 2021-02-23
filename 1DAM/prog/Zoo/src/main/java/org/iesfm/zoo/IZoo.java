package org.iesfm.zoo;

import org.iesfm.zoo.exceptions.CageNotFoundException;
import org.iesfm.zoo.exceptions.NutritionNotFoundException;

public interface IZoo {

    int getAnimalsOfTheCage (int cage) throws CageNotFoundException;

    int getAnimalNutrition (String nutrition) throws NutritionNotFoundException;

    int getAnimalSpeciesOfTheCage (String specie, int cage) throws CageNotFoundException;
}
