// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: payment.proto

package taxPaymentService;

/**
 * <pre>
 * confirmTaxPayments response message: string
 * </pre>
 *
 * Protobuf type {@code paymentServices.TaxPaymentsResponse}
 */
public  final class TaxPaymentsResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:paymentServices.TaxPaymentsResponse)
    TaxPaymentsResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use TaxPaymentsResponse.newBuilder() to construct.
  private TaxPaymentsResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private TaxPaymentsResponse() {
    taxPayments_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private TaxPaymentsResponse(
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
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            taxPayments_ = s;
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
    return taxPaymentService.PaymentBalanceServiceImpl.internal_static_paymentServices_TaxPaymentsResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return taxPaymentService.PaymentBalanceServiceImpl.internal_static_paymentServices_TaxPaymentsResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            taxPaymentService.TaxPaymentsResponse.class, taxPaymentService.TaxPaymentsResponse.Builder.class);
  }

  public static final int TAXPAYMENTS_FIELD_NUMBER = 1;
  private volatile java.lang.Object taxPayments_;
  /**
   * <code>string taxPayments = 1;</code>
   */
  public java.lang.String getTaxPayments() {
    java.lang.Object ref = taxPayments_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      taxPayments_ = s;
      return s;
    }
  }
  /**
   * <code>string taxPayments = 1;</code>
   */
  public com.google.protobuf.ByteString
      getTaxPaymentsBytes() {
    java.lang.Object ref = taxPayments_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      taxPayments_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
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
    if (!getTaxPaymentsBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, taxPayments_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getTaxPaymentsBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, taxPayments_);
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
    if (!(obj instanceof taxPaymentService.TaxPaymentsResponse)) {
      return super.equals(obj);
    }
    taxPaymentService.TaxPaymentsResponse other = (taxPaymentService.TaxPaymentsResponse) obj;

    boolean result = true;
    result = result && getTaxPayments()
        .equals(other.getTaxPayments());
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
    hash = (37 * hash) + TAXPAYMENTS_FIELD_NUMBER;
    hash = (53 * hash) + getTaxPayments().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static taxPaymentService.TaxPaymentsResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static taxPaymentService.TaxPaymentsResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static taxPaymentService.TaxPaymentsResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static taxPaymentService.TaxPaymentsResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static taxPaymentService.TaxPaymentsResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static taxPaymentService.TaxPaymentsResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static taxPaymentService.TaxPaymentsResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static taxPaymentService.TaxPaymentsResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static taxPaymentService.TaxPaymentsResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static taxPaymentService.TaxPaymentsResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static taxPaymentService.TaxPaymentsResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static taxPaymentService.TaxPaymentsResponse parseFrom(
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
  public static Builder newBuilder(taxPaymentService.TaxPaymentsResponse prototype) {
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
   * confirmTaxPayments response message: string
   * </pre>
   *
   * Protobuf type {@code paymentServices.TaxPaymentsResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:paymentServices.TaxPaymentsResponse)
      taxPaymentService.TaxPaymentsResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return taxPaymentService.PaymentBalanceServiceImpl.internal_static_paymentServices_TaxPaymentsResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return taxPaymentService.PaymentBalanceServiceImpl.internal_static_paymentServices_TaxPaymentsResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              taxPaymentService.TaxPaymentsResponse.class, taxPaymentService.TaxPaymentsResponse.Builder.class);
    }

    // Construct using taxPaymentService.TaxPaymentsResponse.newBuilder()
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
      taxPayments_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return taxPaymentService.PaymentBalanceServiceImpl.internal_static_paymentServices_TaxPaymentsResponse_descriptor;
    }

    @java.lang.Override
    public taxPaymentService.TaxPaymentsResponse getDefaultInstanceForType() {
      return taxPaymentService.TaxPaymentsResponse.getDefaultInstance();
    }

    @java.lang.Override
    public taxPaymentService.TaxPaymentsResponse build() {
      taxPaymentService.TaxPaymentsResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public taxPaymentService.TaxPaymentsResponse buildPartial() {
      taxPaymentService.TaxPaymentsResponse result = new taxPaymentService.TaxPaymentsResponse(this);
      result.taxPayments_ = taxPayments_;
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
      if (other instanceof taxPaymentService.TaxPaymentsResponse) {
        return mergeFrom((taxPaymentService.TaxPaymentsResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(taxPaymentService.TaxPaymentsResponse other) {
      if (other == taxPaymentService.TaxPaymentsResponse.getDefaultInstance()) return this;
      if (!other.getTaxPayments().isEmpty()) {
        taxPayments_ = other.taxPayments_;
        onChanged();
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
      taxPaymentService.TaxPaymentsResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (taxPaymentService.TaxPaymentsResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object taxPayments_ = "";
    /**
     * <code>string taxPayments = 1;</code>
     */
    public java.lang.String getTaxPayments() {
      java.lang.Object ref = taxPayments_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        taxPayments_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string taxPayments = 1;</code>
     */
    public com.google.protobuf.ByteString
        getTaxPaymentsBytes() {
      java.lang.Object ref = taxPayments_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        taxPayments_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string taxPayments = 1;</code>
     */
    public Builder setTaxPayments(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      taxPayments_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string taxPayments = 1;</code>
     */
    public Builder clearTaxPayments() {
      
      taxPayments_ = getDefaultInstance().getTaxPayments();
      onChanged();
      return this;
    }
    /**
     * <code>string taxPayments = 1;</code>
     */
    public Builder setTaxPaymentsBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      taxPayments_ = value;
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


    // @@protoc_insertion_point(builder_scope:paymentServices.TaxPaymentsResponse)
  }

  // @@protoc_insertion_point(class_scope:paymentServices.TaxPaymentsResponse)
  private static final taxPaymentService.TaxPaymentsResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new taxPaymentService.TaxPaymentsResponse();
  }

  public static taxPaymentService.TaxPaymentsResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<TaxPaymentsResponse>
      PARSER = new com.google.protobuf.AbstractParser<TaxPaymentsResponse>() {
    @java.lang.Override
    public TaxPaymentsResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new TaxPaymentsResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<TaxPaymentsResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<TaxPaymentsResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public taxPaymentService.TaxPaymentsResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

