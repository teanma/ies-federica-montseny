package org.iesfm.generic;

import org.iesfm.generic.animal.Animal;

public interface Deserializer<T> {

    T deserialize(String value);
}
