/**
 * Autogenerated by Avro
 * <p>
 * DO NOT EDIT DIRECTLY
 */
package com.food.ordering.system.kafka.order.avro.model;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class RestaurantApprovalResponseAvroModel extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
    private static final long serialVersionUID = -3431989201238018220L;


    public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"RestaurantApprovalResponseAvroModel\",\"namespace\":\"com.food.ordering.system.kafka.order.avro.model\",\"fields\":[{\"name\":\"id\",\"type\":{\"type\":\"string\",\"logicalType\":\"uuid\"}},{\"name\":\"sagaId\",\"type\":{\"type\":\"string\",\"logicalType\":\"uuid\"}},{\"name\":\"restaurantId\",\"type\":{\"type\":\"string\",\"logicalType\":\"uuid\"}},{\"name\":\"orderId\",\"type\":{\"type\":\"string\",\"logicalType\":\"uuid\"}},{\"name\":\"createdAt\",\"type\":{\"type\":\"long\",\"logicalType\":\"timestamp-millis\"}},{\"name\":\"orderApprovalStatus\",\"type\":{\"type\":\"enum\",\"name\":\"OrderApprovalStatus\",\"symbols\":[\"APPROVED\",\"REJECTED\"]}},{\"name\":\"failureMessages\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}}]}");

    public static org.apache.avro.Schema getClassSchema() {
        return SCHEMA$;
    }

    private static final SpecificData MODEL$ = new SpecificData();

    static {
        MODEL$.addLogicalTypeConversion(new org.apache.avro.data.TimeConversions.TimestampMillisConversion());
    }

    private static final BinaryMessageEncoder<RestaurantApprovalResponseAvroModel> ENCODER =
            new BinaryMessageEncoder<RestaurantApprovalResponseAvroModel>(MODEL$, SCHEMA$);

    private static final BinaryMessageDecoder<RestaurantApprovalResponseAvroModel> DECODER =
            new BinaryMessageDecoder<RestaurantApprovalResponseAvroModel>(MODEL$, SCHEMA$);

    /**
     * Return the BinaryMessageEncoder instance used by this class.
     * @return the message encoder used by this class
     */
    public static BinaryMessageEncoder<RestaurantApprovalResponseAvroModel> getEncoder() {
        return ENCODER;
    }

    /**
     * Return the BinaryMessageDecoder instance used by this class.
     * @return the message decoder used by this class
     */
    public static BinaryMessageDecoder<RestaurantApprovalResponseAvroModel> getDecoder() {
        return DECODER;
    }

    /**
     * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
     * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
     * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
     */
    public static BinaryMessageDecoder<RestaurantApprovalResponseAvroModel> createDecoder(SchemaStore resolver) {
        return new BinaryMessageDecoder<RestaurantApprovalResponseAvroModel>(MODEL$, SCHEMA$, resolver);
    }

    /**
     * Serializes this RestaurantApprovalResponseAvroModel to a ByteBuffer.
     * @return a buffer holding the serialized data for this instance
     * @throws java.io.IOException if this instance could not be serialized
     */
    public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
        return ENCODER.encode(this);
    }

    /**
     * Deserializes a RestaurantApprovalResponseAvroModel from a ByteBuffer.
     * @param b a byte buffer holding serialized data for an instance of this class
     * @return a RestaurantApprovalResponseAvroModel instance decoded from the given buffer
     * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
     */
    public static RestaurantApprovalResponseAvroModel fromByteBuffer(
            java.nio.ByteBuffer b) throws java.io.IOException {
        return DECODER.decode(b);
    }

    private java.lang.String id;
    private java.lang.String sagaId;
    private java.lang.String restaurantId;
    private java.lang.String orderId;
    private java.time.Instant createdAt;
    private com.food.ordering.system.kafka.order.avro.model.OrderApprovalStatus orderApprovalStatus;
    private java.util.List<java.lang.String> failureMessages;

    /**
     * Default constructor.  Note that this does not initialize fields
     * to their default values from the schema.  If that is desired then
     * one should use <code>newBuilder()</code>.
     */
    public RestaurantApprovalResponseAvroModel() {
    }

    /**
     * All-args constructor.
     * @param id The new value for id
     * @param sagaId The new value for sagaId
     * @param restaurantId The new value for restaurantId
     * @param orderId The new value for orderId
     * @param createdAt The new value for createdAt
     * @param orderApprovalStatus The new value for orderApprovalStatus
     * @param failureMessages The new value for failureMessages
     */
    public RestaurantApprovalResponseAvroModel(java.lang.String id, java.lang.String sagaId, java.lang.String restaurantId, java.lang.String orderId, java.time.Instant createdAt, com.food.ordering.system.kafka.order.avro.model.OrderApprovalStatus orderApprovalStatus, java.util.List<java.lang.String> failureMessages) {
        this.id = id;
        this.sagaId = sagaId;
        this.restaurantId = restaurantId;
        this.orderId = orderId;
        this.createdAt = createdAt.truncatedTo(java.time.temporal.ChronoUnit.MILLIS);
        this.orderApprovalStatus = orderApprovalStatus;
        this.failureMessages = failureMessages;
    }

    public org.apache.avro.specific.SpecificData getSpecificData() {
        return MODEL$;
    }

    public org.apache.avro.Schema getSchema() {
        return SCHEMA$;
    }

    // Used by DatumWriter.  Applications should not call.
    public java.lang.Object get(int field$) {
        switch (field$) {
            case 0:
                return id;
            case 1:
                return sagaId;
            case 2:
                return restaurantId;
            case 3:
                return orderId;
            case 4:
                return createdAt;
            case 5:
                return orderApprovalStatus;
            case 6:
                return failureMessages;
            default:
                throw new IndexOutOfBoundsException("Invalid index: " + field$);
        }
    }

    private static final org.apache.avro.Conversion<?>[] conversions =
            new org.apache.avro.Conversion<?>[]{
                    null,
                    null,
                    null,
                    null,
                    new org.apache.avro.data.TimeConversions.TimestampMillisConversion(),
                    null,
                    null,
                    null
            };

    @Override
    public org.apache.avro.Conversion<?> getConversion(int field) {
        return conversions[field];
    }

    // Used by DatumReader.  Applications should not call.
    @SuppressWarnings(value = "unchecked")
    public void put(int field$, java.lang.Object value$) {
        switch (field$) {
            case 0:
                id = value$ != null ? value$.toString() : null;
                break;
            case 1:
                sagaId = value$ != null ? value$.toString() : null;
                break;
            case 2:
                restaurantId = value$ != null ? value$.toString() : null;
                break;
            case 3:
                orderId = value$ != null ? value$.toString() : null;
                break;
            case 4:
                createdAt = (java.time.Instant) value$;
                break;
            case 5:
                orderApprovalStatus = (com.food.ordering.system.kafka.order.avro.model.OrderApprovalStatus) value$;
                break;
            case 6:
                failureMessages = (java.util.List<java.lang.String>) value$;
                break;
            default:
                throw new IndexOutOfBoundsException("Invalid index: " + field$);
        }
    }

    /**
     * Gets the value of the 'id' field.
     * @return The value of the 'id' field.
     */
    public java.lang.String getId() {
        return id;
    }


    /**
     * Sets the value of the 'id' field.
     * @param value the value to set.
     */
    public void setId(java.lang.String value) {
        this.id = value;
    }

    /**
     * Gets the value of the 'sagaId' field.
     * @return The value of the 'sagaId' field.
     */
    public java.lang.String getSagaId() {
        return sagaId;
    }


    /**
     * Sets the value of the 'sagaId' field.
     * @param value the value to set.
     */
    public void setSagaId(java.lang.String value) {
        this.sagaId = value;
    }

    /**
     * Gets the value of the 'restaurantId' field.
     * @return The value of the 'restaurantId' field.
     */
    public java.lang.String getRestaurantId() {
        return restaurantId;
    }


    /**
     * Sets the value of the 'restaurantId' field.
     * @param value the value to set.
     */
    public void setRestaurantId(java.lang.String value) {
        this.restaurantId = value;
    }

    /**
     * Gets the value of the 'orderId' field.
     * @return The value of the 'orderId' field.
     */
    public java.lang.String getOrderId() {
        return orderId;
    }


    /**
     * Sets the value of the 'orderId' field.
     * @param value the value to set.
     */
    public void setOrderId(java.lang.String value) {
        this.orderId = value;
    }

    /**
     * Gets the value of the 'createdAt' field.
     * @return The value of the 'createdAt' field.
     */
    public java.time.Instant getCreatedAt() {
        return createdAt;
    }


    /**
     * Sets the value of the 'createdAt' field.
     * @param value the value to set.
     */
    public void setCreatedAt(java.time.Instant value) {
        this.createdAt = value.truncatedTo(java.time.temporal.ChronoUnit.MILLIS);
    }

    /**
     * Gets the value of the 'orderApprovalStatus' field.
     * @return The value of the 'orderApprovalStatus' field.
     */
    public com.food.ordering.system.kafka.order.avro.model.OrderApprovalStatus getOrderApprovalStatus() {
        return orderApprovalStatus;
    }


    /**
     * Sets the value of the 'orderApprovalStatus' field.
     * @param value the value to set.
     */
    public void setOrderApprovalStatus(com.food.ordering.system.kafka.order.avro.model.OrderApprovalStatus value) {
        this.orderApprovalStatus = value;
    }

    /**
     * Gets the value of the 'failureMessages' field.
     * @return The value of the 'failureMessages' field.
     */
    public java.util.List<java.lang.String> getFailureMessages() {
        return failureMessages;
    }


    /**
     * Sets the value of the 'failureMessages' field.
     * @param value the value to set.
     */
    public void setFailureMessages(java.util.List<java.lang.String> value) {
        this.failureMessages = value;
    }

    /**
     * Creates a new RestaurantApprovalResponseAvroModel RecordBuilder.
     * @return A new RestaurantApprovalResponseAvroModel RecordBuilder
     */
    public static com.food.ordering.system.kafka.order.avro.model.RestaurantApprovalResponseAvroModel.Builder newBuilder() {
        return new com.food.ordering.system.kafka.order.avro.model.RestaurantApprovalResponseAvroModel.Builder();
    }

    /**
     * Creates a new RestaurantApprovalResponseAvroModel RecordBuilder by copying an existing Builder.
     * @param other The existing builder to copy.
     * @return A new RestaurantApprovalResponseAvroModel RecordBuilder
     */
    public static com.food.ordering.system.kafka.order.avro.model.RestaurantApprovalResponseAvroModel.Builder newBuilder(com.food.ordering.system.kafka.order.avro.model.RestaurantApprovalResponseAvroModel.Builder other) {
        if (other == null) {
            return new com.food.ordering.system.kafka.order.avro.model.RestaurantApprovalResponseAvroModel.Builder();
        } else {
            return new com.food.ordering.system.kafka.order.avro.model.RestaurantApprovalResponseAvroModel.Builder(other);
        }
    }

    /**
     * Creates a new RestaurantApprovalResponseAvroModel RecordBuilder by copying an existing RestaurantApprovalResponseAvroModel instance.
     * @param other The existing instance to copy.
     * @return A new RestaurantApprovalResponseAvroModel RecordBuilder
     */
    public static com.food.ordering.system.kafka.order.avro.model.RestaurantApprovalResponseAvroModel.Builder newBuilder(com.food.ordering.system.kafka.order.avro.model.RestaurantApprovalResponseAvroModel other) {
        if (other == null) {
            return new com.food.ordering.system.kafka.order.avro.model.RestaurantApprovalResponseAvroModel.Builder();
        } else {
            return new com.food.ordering.system.kafka.order.avro.model.RestaurantApprovalResponseAvroModel.Builder(other);
        }
    }

    /**
     * RecordBuilder for RestaurantApprovalResponseAvroModel instances.
     */
    @org.apache.avro.specific.AvroGenerated
    public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<RestaurantApprovalResponseAvroModel>
            implements org.apache.avro.data.RecordBuilder<RestaurantApprovalResponseAvroModel> {

        private java.lang.String id;
        private java.lang.String sagaId;
        private java.lang.String restaurantId;
        private java.lang.String orderId;
        private java.time.Instant createdAt;
        private com.food.ordering.system.kafka.order.avro.model.OrderApprovalStatus orderApprovalStatus;
        private java.util.List<java.lang.String> failureMessages;

        /** Creates a new Builder */
        private Builder() {
            super(SCHEMA$, MODEL$);
        }

        /**
         * Creates a Builder by copying an existing Builder.
         * @param other The existing Builder to copy.
         */
        private Builder(com.food.ordering.system.kafka.order.avro.model.RestaurantApprovalResponseAvroModel.Builder other) {
            super(other);
            if (isValidValue(fields()[0], other.id)) {
                this.id = data().deepCopy(fields()[0].schema(), other.id);
                fieldSetFlags()[0] = other.fieldSetFlags()[0];
            }
            if (isValidValue(fields()[1], other.sagaId)) {
                this.sagaId = data().deepCopy(fields()[1].schema(), other.sagaId);
                fieldSetFlags()[1] = other.fieldSetFlags()[1];
            }
            if (isValidValue(fields()[2], other.restaurantId)) {
                this.restaurantId = data().deepCopy(fields()[2].schema(), other.restaurantId);
                fieldSetFlags()[2] = other.fieldSetFlags()[2];
            }
            if (isValidValue(fields()[3], other.orderId)) {
                this.orderId = data().deepCopy(fields()[3].schema(), other.orderId);
                fieldSetFlags()[3] = other.fieldSetFlags()[3];
            }
            if (isValidValue(fields()[4], other.createdAt)) {
                this.createdAt = data().deepCopy(fields()[4].schema(), other.createdAt);
                fieldSetFlags()[4] = other.fieldSetFlags()[4];
            }
            if (isValidValue(fields()[5], other.orderApprovalStatus)) {
                this.orderApprovalStatus = data().deepCopy(fields()[5].schema(), other.orderApprovalStatus);
                fieldSetFlags()[5] = other.fieldSetFlags()[5];
            }
            if (isValidValue(fields()[6], other.failureMessages)) {
                this.failureMessages = data().deepCopy(fields()[6].schema(), other.failureMessages);
                fieldSetFlags()[6] = other.fieldSetFlags()[6];
            }
        }

        /**
         * Creates a Builder by copying an existing RestaurantApprovalResponseAvroModel instance
         * @param other The existing instance to copy.
         */
        private Builder(com.food.ordering.system.kafka.order.avro.model.RestaurantApprovalResponseAvroModel other) {
            super(SCHEMA$, MODEL$);
            if (isValidValue(fields()[0], other.id)) {
                this.id = data().deepCopy(fields()[0].schema(), other.id);
                fieldSetFlags()[0] = true;
            }
            if (isValidValue(fields()[1], other.sagaId)) {
                this.sagaId = data().deepCopy(fields()[1].schema(), other.sagaId);
                fieldSetFlags()[1] = true;
            }
            if (isValidValue(fields()[2], other.restaurantId)) {
                this.restaurantId = data().deepCopy(fields()[2].schema(), other.restaurantId);
                fieldSetFlags()[2] = true;
            }
            if (isValidValue(fields()[3], other.orderId)) {
                this.orderId = data().deepCopy(fields()[3].schema(), other.orderId);
                fieldSetFlags()[3] = true;
            }
            if (isValidValue(fields()[4], other.createdAt)) {
                this.createdAt = data().deepCopy(fields()[4].schema(), other.createdAt);
                fieldSetFlags()[4] = true;
            }
            if (isValidValue(fields()[5], other.orderApprovalStatus)) {
                this.orderApprovalStatus = data().deepCopy(fields()[5].schema(), other.orderApprovalStatus);
                fieldSetFlags()[5] = true;
            }
            if (isValidValue(fields()[6], other.failureMessages)) {
                this.failureMessages = data().deepCopy(fields()[6].schema(), other.failureMessages);
                fieldSetFlags()[6] = true;
            }
        }

        /**
         * Gets the value of the 'id' field.
         * @return The value.
         */
        public java.lang.String getId() {
            return id;
        }


        /**
         * Sets the value of the 'id' field.
         * @param value The value of 'id'.
         * @return This builder.
         */
        public com.food.ordering.system.kafka.order.avro.model.RestaurantApprovalResponseAvroModel.Builder setId(java.lang.String value) {
            validate(fields()[0], value);
            this.id = value;
            fieldSetFlags()[0] = true;
            return this;
        }

        /**
         * Checks whether the 'id' field has been set.
         * @return True if the 'id' field has been set, false otherwise.
         */
        public boolean hasId() {
            return fieldSetFlags()[0];
        }


        /**
         * Clears the value of the 'id' field.
         * @return This builder.
         */
        public com.food.ordering.system.kafka.order.avro.model.RestaurantApprovalResponseAvroModel.Builder clearId() {
            id = null;
            fieldSetFlags()[0] = false;
            return this;
        }

        /**
         * Gets the value of the 'sagaId' field.
         * @return The value.
         */
        public java.lang.String getSagaId() {
            return sagaId;
        }


        /**
         * Sets the value of the 'sagaId' field.
         * @param value The value of 'sagaId'.
         * @return This builder.
         */
        public com.food.ordering.system.kafka.order.avro.model.RestaurantApprovalResponseAvroModel.Builder setSagaId(java.lang.String value) {
            validate(fields()[1], value);
            this.sagaId = value;
            fieldSetFlags()[1] = true;
            return this;
        }

        /**
         * Checks whether the 'sagaId' field has been set.
         * @return True if the 'sagaId' field has been set, false otherwise.
         */
        public boolean hasSagaId() {
            return fieldSetFlags()[1];
        }


        /**
         * Clears the value of the 'sagaId' field.
         * @return This builder.
         */
        public com.food.ordering.system.kafka.order.avro.model.RestaurantApprovalResponseAvroModel.Builder clearSagaId() {
            sagaId = null;
            fieldSetFlags()[1] = false;
            return this;
        }

        /**
         * Gets the value of the 'restaurantId' field.
         * @return The value.
         */
        public java.lang.String getRestaurantId() {
            return restaurantId;
        }


        /**
         * Sets the value of the 'restaurantId' field.
         * @param value The value of 'restaurantId'.
         * @return This builder.
         */
        public com.food.ordering.system.kafka.order.avro.model.RestaurantApprovalResponseAvroModel.Builder setRestaurantId(java.lang.String value) {
            validate(fields()[2], value);
            this.restaurantId = value;
            fieldSetFlags()[2] = true;
            return this;
        }

        /**
         * Checks whether the 'restaurantId' field has been set.
         * @return True if the 'restaurantId' field has been set, false otherwise.
         */
        public boolean hasRestaurantId() {
            return fieldSetFlags()[2];
        }


        /**
         * Clears the value of the 'restaurantId' field.
         * @return This builder.
         */
        public com.food.ordering.system.kafka.order.avro.model.RestaurantApprovalResponseAvroModel.Builder clearRestaurantId() {
            restaurantId = null;
            fieldSetFlags()[2] = false;
            return this;
        }

        /**
         * Gets the value of the 'orderId' field.
         * @return The value.
         */
        public java.lang.String getOrderId() {
            return orderId;
        }


        /**
         * Sets the value of the 'orderId' field.
         * @param value The value of 'orderId'.
         * @return This builder.
         */
        public com.food.ordering.system.kafka.order.avro.model.RestaurantApprovalResponseAvroModel.Builder setOrderId(java.lang.String value) {
            validate(fields()[3], value);
            this.orderId = value;
            fieldSetFlags()[3] = true;
            return this;
        }

        /**
         * Checks whether the 'orderId' field has been set.
         * @return True if the 'orderId' field has been set, false otherwise.
         */
        public boolean hasOrderId() {
            return fieldSetFlags()[3];
        }


        /**
         * Clears the value of the 'orderId' field.
         * @return This builder.
         */
        public com.food.ordering.system.kafka.order.avro.model.RestaurantApprovalResponseAvroModel.Builder clearOrderId() {
            orderId = null;
            fieldSetFlags()[3] = false;
            return this;
        }

        /**
         * Gets the value of the 'createdAt' field.
         * @return The value.
         */
        public java.time.Instant getCreatedAt() {
            return createdAt;
        }


        /**
         * Sets the value of the 'createdAt' field.
         * @param value The value of 'createdAt'.
         * @return This builder.
         */
        public com.food.ordering.system.kafka.order.avro.model.RestaurantApprovalResponseAvroModel.Builder setCreatedAt(java.time.Instant value) {
            validate(fields()[4], value);
            this.createdAt = value.truncatedTo(java.time.temporal.ChronoUnit.MILLIS);
            fieldSetFlags()[4] = true;
            return this;
        }

        /**
         * Checks whether the 'createdAt' field has been set.
         * @return True if the 'createdAt' field has been set, false otherwise.
         */
        public boolean hasCreatedAt() {
            return fieldSetFlags()[4];
        }


        /**
         * Clears the value of the 'createdAt' field.
         * @return This builder.
         */
        public com.food.ordering.system.kafka.order.avro.model.RestaurantApprovalResponseAvroModel.Builder clearCreatedAt() {
            fieldSetFlags()[4] = false;
            return this;
        }

        /**
         * Gets the value of the 'orderApprovalStatus' field.
         * @return The value.
         */
        public com.food.ordering.system.kafka.order.avro.model.OrderApprovalStatus getOrderApprovalStatus() {
            return orderApprovalStatus;
        }


        /**
         * Sets the value of the 'orderApprovalStatus' field.
         * @param value The value of 'orderApprovalStatus'.
         * @return This builder.
         */
        public com.food.ordering.system.kafka.order.avro.model.RestaurantApprovalResponseAvroModel.Builder setOrderApprovalStatus(com.food.ordering.system.kafka.order.avro.model.OrderApprovalStatus value) {
            validate(fields()[5], value);
            this.orderApprovalStatus = value;
            fieldSetFlags()[5] = true;
            return this;
        }

        /**
         * Checks whether the 'orderApprovalStatus' field has been set.
         * @return True if the 'orderApprovalStatus' field has been set, false otherwise.
         */
        public boolean hasOrderApprovalStatus() {
            return fieldSetFlags()[5];
        }


        /**
         * Clears the value of the 'orderApprovalStatus' field.
         * @return This builder.
         */
        public com.food.ordering.system.kafka.order.avro.model.RestaurantApprovalResponseAvroModel.Builder clearOrderApprovalStatus() {
            orderApprovalStatus = null;
            fieldSetFlags()[5] = false;
            return this;
        }

        /**
         * Gets the value of the 'failureMessages' field.
         * @return The value.
         */
        public java.util.List<java.lang.String> getFailureMessages() {
            return failureMessages;
        }


        /**
         * Sets the value of the 'failureMessages' field.
         * @param value The value of 'failureMessages'.
         * @return This builder.
         */
        public com.food.ordering.system.kafka.order.avro.model.RestaurantApprovalResponseAvroModel.Builder setFailureMessages(java.util.List<java.lang.String> value) {
            validate(fields()[6], value);
            this.failureMessages = value;
            fieldSetFlags()[6] = true;
            return this;
        }

        /**
         * Checks whether the 'failureMessages' field has been set.
         * @return True if the 'failureMessages' field has been set, false otherwise.
         */
        public boolean hasFailureMessages() {
            return fieldSetFlags()[6];
        }


        /**
         * Clears the value of the 'failureMessages' field.
         * @return This builder.
         */
        public com.food.ordering.system.kafka.order.avro.model.RestaurantApprovalResponseAvroModel.Builder clearFailureMessages() {
            failureMessages = null;
            fieldSetFlags()[6] = false;
            return this;
        }

        @Override
        @SuppressWarnings("unchecked")
        public RestaurantApprovalResponseAvroModel build() {
            try {
                RestaurantApprovalResponseAvroModel record = new RestaurantApprovalResponseAvroModel();
                record.id = fieldSetFlags()[0] ? this.id : (java.lang.String) defaultValue(fields()[0]);
                record.sagaId = fieldSetFlags()[1] ? this.sagaId : (java.lang.String) defaultValue(fields()[1]);
                record.restaurantId = fieldSetFlags()[2] ? this.restaurantId : (java.lang.String) defaultValue(fields()[2]);
                record.orderId = fieldSetFlags()[3] ? this.orderId : (java.lang.String) defaultValue(fields()[3]);
                record.createdAt = fieldSetFlags()[4] ? this.createdAt : (java.time.Instant) defaultValue(fields()[4]);
                record.orderApprovalStatus = fieldSetFlags()[5] ? this.orderApprovalStatus : (com.food.ordering.system.kafka.order.avro.model.OrderApprovalStatus) defaultValue(fields()[5]);
                record.failureMessages = fieldSetFlags()[6] ? this.failureMessages : (java.util.List<java.lang.String>) defaultValue(fields()[6]);
                return record;
            } catch (org.apache.avro.AvroMissingFieldException e) {
                throw e;
            } catch (java.lang.Exception e) {
                throw new org.apache.avro.AvroRuntimeException(e);
            }
        }
    }

    @SuppressWarnings("unchecked")
    private static final org.apache.avro.io.DatumWriter<RestaurantApprovalResponseAvroModel>
            WRITER$ = (org.apache.avro.io.DatumWriter<RestaurantApprovalResponseAvroModel>) MODEL$.createDatumWriter(SCHEMA$);

    @Override
    public void writeExternal(java.io.ObjectOutput out)
            throws java.io.IOException {
        WRITER$.write(this, SpecificData.getEncoder(out));
    }

    @SuppressWarnings("unchecked")
    private static final org.apache.avro.io.DatumReader<RestaurantApprovalResponseAvroModel>
            READER$ = (org.apache.avro.io.DatumReader<RestaurantApprovalResponseAvroModel>) MODEL$.createDatumReader(SCHEMA$);

    @Override
    public void readExternal(java.io.ObjectInput in)
            throws java.io.IOException {
        READER$.read(this, SpecificData.getDecoder(in));
    }

}










