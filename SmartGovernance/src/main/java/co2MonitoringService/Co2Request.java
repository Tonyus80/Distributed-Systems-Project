// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: co2Monitoring.proto

package co2MonitoringService;

/**
 * <pre>
 *Bi-Directional
 * </pre>
 *
 * Protobuf type {@code co2MonitoringService.Co2Request}
 */
public  final class Co2Request extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:co2MonitoringService.Co2Request)
    Co2RequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use Co2Request.newBuilder() to construct.
  private Co2Request(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Co2Request() {
    carbon_ = 0F;
    oxygen_ = 0F;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private Co2Request(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 13: {

            carbon_ = input.readFloat();
            break;
          }
          case 21: {

            oxygen_ = input.readFloat();
            break;
          }
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return co2MonitoringService.Co2MonitoringServiceImpl.internal_static_co2MonitoringService_Co2Request_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return co2MonitoringService.Co2MonitoringServiceImpl.internal_static_co2MonitoringService_Co2Request_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            co2MonitoringService.Co2Request.class, co2MonitoringService.Co2Request.Builder.class);
  }

  public static final int CARBON_FIELD_NUMBER = 1;
  private float carbon_;
  /**
   * <code>float carbon = 1;</code>
   */
  public float getCarbon() {
    return carbon_;
  }

  public static final int OXYGEN_FIELD_NUMBER = 2;
  private float oxygen_;
  /**
   * <code>float oxygen = 2;</code>
   */
  public float getOxygen() {
    return oxygen_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (carbon_ != 0F) {
      output.writeFloat(1, carbon_);
    }
    if (oxygen_ != 0F) {
      output.writeFloat(2, oxygen_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (carbon_ != 0F) {
      size += com.google.protobuf.CodedOutputStream
        .computeFloatSize(1, carbon_);
    }
    if (oxygen_ != 0F) {
      size += com.google.protobuf.CodedOutputStream
        .computeFloatSize(2, oxygen_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof co2MonitoringService.Co2Request)) {
      return super.equals(obj);
    }
    co2MonitoringService.Co2Request other = (co2MonitoringService.Co2Request) obj;

    boolean result = true;
    result = result && (
        java.lang.Float.floatToIntBits(getCarbon())
        == java.lang.Float.floatToIntBits(
            other.getCarbon()));
    result = result && (
        java.lang.Float.floatToIntBits(getOxygen())
        == java.lang.Float.floatToIntBits(
            other.getOxygen()));
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + CARBON_FIELD_NUMBER;
    hash = (53 * hash) + java.lang.Float.floatToIntBits(
        getCarbon());
    hash = (37 * hash) + OXYGEN_FIELD_NUMBER;
    hash = (53 * hash) + java.lang.Float.floatToIntBits(
        getOxygen());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static co2MonitoringService.Co2Request parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static co2MonitoringService.Co2Request parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static co2MonitoringService.Co2Request parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static co2MonitoringService.Co2Request parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static co2MonitoringService.Co2Request parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static co2MonitoringService.Co2Request parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static co2MonitoringService.Co2Request parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static co2MonitoringService.Co2Request parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static co2MonitoringService.Co2Request parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static co2MonitoringService.Co2Request parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static co2MonitoringService.Co2Request parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static co2MonitoringService.Co2Request parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(co2MonitoringService.Co2Request prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * <pre>
   *Bi-Directional
   * </pre>
   *
   * Protobuf type {@code co2MonitoringService.Co2Request}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:co2MonitoringService.Co2Request)
      co2MonitoringService.Co2RequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return co2MonitoringService.Co2MonitoringServiceImpl.internal_static_co2MonitoringService_Co2Request_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return co2MonitoringService.Co2MonitoringServiceImpl.internal_static_co2MonitoringService_Co2Request_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              co2MonitoringService.Co2Request.class, co2MonitoringService.Co2Request.Builder.class);
    }

    // Construct using co2MonitoringService.Co2Request.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      carbon_ = 0F;

      oxygen_ = 0F;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return co2MonitoringService.Co2MonitoringServiceImpl.internal_static_co2MonitoringService_Co2Request_descriptor;
    }

    @java.lang.Override
    public co2MonitoringService.Co2Request getDefaultInstanceForType() {
      return co2MonitoringService.Co2Request.getDefaultInstance();
    }

    @java.lang.Override
    public co2MonitoringService.Co2Request build() {
      co2MonitoringService.Co2Request result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public co2MonitoringService.Co2Request buildPartial() {
      co2MonitoringService.Co2Request result = new co2MonitoringService.Co2Request(this);
      result.carbon_ = carbon_;
      result.oxygen_ = oxygen_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return (Builder) super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof co2MonitoringService.Co2Request) {
        return mergeFrom((co2MonitoringService.Co2Request)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(co2MonitoringService.Co2Request other) {
      if (other == co2MonitoringService.Co2Request.getDefaultInstance()) return this;
      if (other.getCarbon() != 0F) {
        setCarbon(other.getCarbon());
      }
      if (other.getOxygen() != 0F) {
        setOxygen(other.getOxygen());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      co2MonitoringService.Co2Request parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (co2MonitoringService.Co2Request) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private float carbon_ ;
    /**
     * <code>float carbon = 1;</code>
     */
    public float getCarbon() {
      return carbon_;
    }
    /**
     * <code>float carbon = 1;</code>
     */
    public Builder setCarbon(float value) {
      
      carbon_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>float carbon = 1;</code>
     */
    public Builder clearCarbon() {
      
      carbon_ = 0F;
      onChanged();
      return this;
    }

    private float oxygen_ ;
    /**
     * <code>float oxygen = 2;</code>
     */
    public float getOxygen() {
      return oxygen_;
    }
    /**
     * <code>float oxygen = 2;</code>
     */
    public Builder setOxygen(float value) {
      
      oxygen_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>float oxygen = 2;</code>
     */
    public Builder clearOxygen() {
      
      oxygen_ = 0F;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:co2MonitoringService.Co2Request)
  }

  // @@protoc_insertion_point(class_scope:co2MonitoringService.Co2Request)
  private static final co2MonitoringService.Co2Request DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new co2MonitoringService.Co2Request();
  }

  public static co2MonitoringService.Co2Request getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Co2Request>
      PARSER = new com.google.protobuf.AbstractParser<Co2Request>() {
    @java.lang.Override
    public Co2Request parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new Co2Request(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<Co2Request> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Co2Request> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public co2MonitoringService.Co2Request getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

