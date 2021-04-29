package org.iesfm.generic;

import org.junit.Assert;
import org.junit.Test;

public class ListaTest {

    @Test
    public void addEmptyTest() {
        Lista<String> listaStrings = new Lista<>();

        listaStrings.add("hola");

        Assert.assertEquals("hola", listaStrings.getHead().getValue());

    }

    @Test
    public void addNotEmptyTest() {
        Lista<String> listaStrings = new Lista<>(new Node<>("adiós"));

        listaStrings.add("hola");

        Assert.assertEquals("hola", listaStrings.getHead().getValue());

    }

    @Test
    public void getHeadTest() {
        Lista<String> listString = new Lista<>(new Node<>("adiós", new Node<>("hola")));

        Assert.assertEquals("hola", listString.get(0));
    }

    @Test
    public void getLastTest() {
        Lista<String> listString = new Lista<>(new Node<>("adiós", new Node<>("hola")));

        Assert.assertEquals("hola", listString.get(1));
    }

    @Test
    public void getOutOfBoundTest() {
        Lista<String> listString = new Lista<>(new Node<>("adiós", new Node<>("hola")));

        listString.get(2);
    }

    @Test
    public void removeHeadTest() {
        Lista<String> listString = new Lista<>(new Node<>("adiós", new Node<>("hola", null)));

        listString.removeHead();

        Assert.assertEquals("hola", listString.getHead().getValue());
        Assert.assertEquals(1, listString.size());
    }

    @Test
    public void removeHeadNoNextValueTest() {
        Lista<String> listString = new Lista<>(new Node<>("adiós", new Node<>("hola", null)));

        listString.removeHead();

        Assert.assertNull(listString.getHead());

    }

    @Test
    public void removeLast() {
        Lista<String> listString = new Lista<>(new Node<>("adiós", new Node<>("hola", null)));

        listString.removeLast();

        Assert.assertEquals("hola", listString.getHead().getValue());
        Assert.assertEquals(1, listString.size());
    }

    @Test
    public void removeLastSingleElementLast() {
        Lista<String> listString = new Lista<>(new Node<>("hola", null));

        listString.removeLast();

        Assert.assertNull(listString.getHead());
        Assert.assertEquals(0, listString.size());
    }


}
