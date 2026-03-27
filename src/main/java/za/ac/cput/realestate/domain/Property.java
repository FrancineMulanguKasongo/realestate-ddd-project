/* Property.java
   Property model class
   Author: Francine Mulangu Kasongo (230978649)
   Date: March 2026
*/

package za.ac.cput.realestate.domain;

    public class Property {
        // Attributes from UML
        private String propertyId;
        private String address;
        private double price;
        private int bedrooms;
        private double bathrooms;
        private String propertyType;
        private String status;

        // Private constructor - only Builder can use it
        private Property(Builder builder) {
            this.propertyId = builder.propertyId;
            this.address = builder.address;
            this.price = builder.price;
            this.bedrooms = builder.bedrooms;
            this.bathrooms = builder.bathrooms;
            this.propertyType = builder.propertyType;
            this.status = builder.status;
        }

        // Getters (NO setters - immutable object)
        public String getPropertyId() {
            return propertyId;
        }

        public String getAddress() {
            return address;
        }

        public double getPrice() {
            return price;
        }

        public int getBedrooms() {
            return bedrooms;
        }

        public double getBathrooms() {
            return bathrooms;
        }

        public String getPropertyType() {
            return propertyType;
        }

        public String getStatus() {
            return status;
        }

        // Builder Pattern Implementation
        public static class Builder {
            private String propertyId;
            private String address;
            private double price;
            private int bedrooms;
            private double bathrooms;
            private String propertyType;
            private String status;

            public Builder propertyId(String propertyId) {
                this.propertyId = propertyId;
                return this;
            }

            public Builder address(String address) {
                this.address = address;
                return this;
            }

            public Builder price(double price) {
                this.price = price;
                return this;
            }

            public Builder bedrooms(int bedrooms) {
                this.bedrooms = bedrooms;
                return this;
            }

            public Builder bathrooms(double bathrooms) {
                this.bathrooms = bathrooms;
                return this;
            }

            public Builder propertyType(String propertyType) {
                this.propertyType = propertyType;
                return this;
            }

            public Builder status(String status) {
                this.status = status;
                return this;
            }

            public Property build() {
                // Validation
                if (propertyId == null || propertyId.isEmpty()) {
                    throw new IllegalArgumentException("Property ID is required");
                }
                if (address == null || address.isEmpty()) {
                    throw new IllegalArgumentException("Address is required");
                }
                if (price <= 0) {
                    throw new IllegalArgumentException("Price must be greater than 0");
                }
                return new Property(this);
            }
        }

        @Override
        public String toString() {
            return "Property{" +
                    "propertyId='" + propertyId + '\'' +
                    ", address='" + address + '\'' +
                    ", price=" + price +
                    ", bedrooms=" + bedrooms +
                    ", bathrooms=" + bathrooms +
                    ", propertyType='" + propertyType + '\'' +
                    ", status='" + status + '\'' +
                    '}';
        }
    }

