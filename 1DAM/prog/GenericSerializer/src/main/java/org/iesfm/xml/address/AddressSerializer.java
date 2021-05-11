package org.iesfm.xml.address;

import org.iesfm.xml.XmlSerializer;

public class AddressSerializer implements XmlSerializer<Address> {

    @Override
    public String toXml(Address address) {

        String streetElement = "<street>" + address.getStreet() + "</street>";
        String numberElement = "<number>" + address.getNumber() + "</number>";
        String doorElement = "<door>" + address.getDoor() + "</door>";
        String cityElement = "<city>" + address.getCity() + "</city>";

        String addressElement = "<address>" + streetElement + numberElement + doorElement + cityElement + "</address>";

        return addressElement;
    }
}
