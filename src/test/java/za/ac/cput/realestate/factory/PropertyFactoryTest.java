
    /* PropertyFactoryTest.java
   Test class for PropertyFactory
   Author: Francine Mulangu Kasongo (230978649)
   Date: March 2026
*/

package za.ac.cput.realestate.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.realestate.domain.Property;

import static org.junit.jupiter.api.Assertions.*;

    class PropertyFactoryTest {

        @Test
        void testCreatePropertySuccess() {
            Property property = PropertyFactory.createProperty(
                    "P001",
                    "123 Main Street, Cape Town",
                    2500000.00,
                    3,
                    2.0,
                    "House",
                    "Available"
            );

            assertNotNull(property);
            assertEquals("P001", property.getPropertyId());
            assertEquals("123 Main Street, Cape Town", property.getAddress());
            assertEquals(2500000.00, property.getPrice());
            assertEquals(3, property.getBedrooms());
            assertEquals(2.0, property.getBathrooms());
            assertEquals("House", property.getPropertyType());
            assertEquals("Available", property.getStatus());
        }

        @Test
        void testCreatePropertyWithNullId() {
            assertThrows(IllegalArgumentException.class, () -> {
                PropertyFactory.createProperty(
                        null,
                        "123 Main Street",
                        2500000.00,
                        3,
                        2.0,
                        "House",
                        "Available"
                );
            });
        }

        @Test
        void testCreatePropertyWithEmptyId() {
            assertThrows(IllegalArgumentException.class, () -> {
                PropertyFactory.createProperty(
                        "",
                        "123 Main Street",
                        2500000.00,
                        3,
                        2.0,
                        "House",
                        "Available"
                );
            });
        }

        @Test
        void testCreatePropertyWithInvalidPrice() {
            assertThrows(IllegalArgumentException.class, () -> {
                PropertyFactory.createProperty(
                        "P002",
                        "456 Oak Avenue",
                        -1000.00,
                        2,
                        1.0,
                        "Apartment",
                        "Sold"
                );
            });
        }
    }

