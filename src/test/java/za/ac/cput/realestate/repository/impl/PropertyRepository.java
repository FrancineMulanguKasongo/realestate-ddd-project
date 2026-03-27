/* PropertyRepository.java
   Repository implementation for Property entity
   Author: Francine Mulangu Kasongo (230978649)
   Date: March 2026
*/

package za.ac.cput.realestate.repository.impl;

import za.ac.cput.realestate.domain.Property;
import za.ac.cput.realestate.repository.IRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

    public class PropertyRepository implements IRepository<Property, String> {

        // Singleton instance
        private static PropertyRepository instance = null;

        // In-memory storage
        private List<Property> propertyList;

        // Private constructor (Singleton Pattern)
        private PropertyRepository() {
            propertyList = new ArrayList<>();
        }

        // Get singleton instance
        public static PropertyRepository getInstance() {
            if (instance == null) {
                instance = new PropertyRepository();
            }
            return instance;
        }

        @Override
        public Property create(Property property) {
            // Check if property already exists
            if (read(property.getPropertyId()) != null) {
                return null; // Property already exists
            }
            propertyList.add(property);
            return property;
        }

        @Override
        public Property read(String propertyId) {
            Optional<Property> found = propertyList.stream()
                    .filter(p -> p.getPropertyId().equals(propertyId))
                    .findFirst();
            return found.orElse(null);
        }

        @Override
        public Property update(Property property) {
            Property existing = read(property.getPropertyId());
            if (existing != null) {
                propertyList.remove(existing);
                propertyList.add(property);
                return property;
            }
            return null; // Property not found
        }

        @Override
        public boolean delete(String propertyId) {
            Property existing = read(propertyId);
            if (existing != null) {
                propertyList.remove(existing);
            }
            return false;
        }

        @Override
        public List<Property> getAll() {
            return propertyList;
        }
    }


