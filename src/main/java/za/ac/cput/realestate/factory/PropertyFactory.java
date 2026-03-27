/* PropertyFactory.java
   Factory class for Property entity
   Author: Francine Mulangu Kasongo (230978649)
   Date: March 2026
*/

package za.ac.cput.realestate.factory;

import za.ac.cput.realestate.domain.Property;

    public class PropertyFactory {

        public static Property createProperty(String propertyId,
                                              String address,
                                              double price,
                                              int bedrooms,
                                              double bathrooms,
                                              String propertyType,
                                              String status) {

            return new Property.Builder()
                    .propertyId(propertyId)
                    .address(address)
                    .price(price)
                    .bedrooms(bedrooms)
                    .bathrooms(bathrooms)
                    .propertyType(propertyType)
                    .status(status)
                    .build();
        }
    }

