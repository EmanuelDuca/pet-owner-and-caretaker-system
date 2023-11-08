// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: protobuf.proto

package origin.protobuf;

/**
 * Protobuf type {@code TimeIntervalProto}
 */
public  final class TimeIntervalProto extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:TimeIntervalProto)
    TimeIntervalProtoOrBuilder {
  // Use TimeIntervalProto.newBuilder() to construct.
  private TimeIntervalProto(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private TimeIntervalProto() {
    startDate_ = "";
    finishDate_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private TimeIntervalProto(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    int mutable_bitField0_ = 0;
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!input.skipField(tag)) {
              done = true;
            }
            break;
          }
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            startDate_ = s;
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            finishDate_ = s;
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
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return origin.protobuf.Protobuf.internal_static_TimeIntervalProto_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return origin.protobuf.Protobuf.internal_static_TimeIntervalProto_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            origin.protobuf.TimeIntervalProto.class, origin.protobuf.TimeIntervalProto.Builder.class);
  }

  public static final int STARTDATE_FIELD_NUMBER = 1;
  private volatile java.lang.Object startDate_;
  /**
   * <code>string startDate = 1;</code>
   */
  public java.lang.String getStartDate() {
    java.lang.Object ref = startDate_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      startDate_ = s;
      return s;
    }
  }
  /**
   * <code>string startDate = 1;</code>
   */
  public com.google.protobuf.ByteString
      getStartDateBytes() {
    java.lang.Object ref = startDate_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      startDate_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int FINISHDATE_FIELD_NUMBER = 2;
  private volatile java.lang.Object finishDate_;
  /**
   * <code>string finishDate = 2;</code>
   */
  public java.lang.String getFinishDate() {
    java.lang.Object ref = finishDate_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      finishDate_ = s;
      return s;
    }
  }
  /**
   * <code>string finishDate = 2;</code>
   */
  public com.google.protobuf.ByteString
      getFinishDateBytes() {
    java.lang.Object ref = finishDate_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      finishDate_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!getStartDateBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, startDate_);
    }
    if (!getFinishDateBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, finishDate_);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getStartDateBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, startDate_);
    }
    if (!getFinishDateBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, finishDate_);
    }
    memoizedSize = size;
    return size;
  }

  private static final long serialVersionUID = 0L;
  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof origin.protobuf.TimeIntervalProto)) {
      return super.equals(obj);
    }
    origin.protobuf.TimeIntervalProto other = (origin.protobuf.TimeIntervalProto) obj;

    boolean result = true;
    result = result && getStartDate()
        .equals(other.getStartDate());
    result = result && getFinishDate()
        .equals(other.getFinishDate());
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + STARTDATE_FIELD_NUMBER;
    hash = (53 * hash) + getStartDate().hashCode();
    hash = (37 * hash) + FINISHDATE_FIELD_NUMBER;
    hash = (53 * hash) + getFinishDate().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static origin.protobuf.TimeIntervalProto parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static origin.protobuf.TimeIntervalProto parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static origin.protobuf.TimeIntervalProto parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static origin.protobuf.TimeIntervalProto parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static origin.protobuf.TimeIntervalProto parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static origin.protobuf.TimeIntervalProto parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static origin.protobuf.TimeIntervalProto parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static origin.protobuf.TimeIntervalProto parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static origin.protobuf.TimeIntervalProto parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static origin.protobuf.TimeIntervalProto parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static origin.protobuf.TimeIntervalProto parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static origin.protobuf.TimeIntervalProto parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(origin.protobuf.TimeIntervalProto prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
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
   * Protobuf type {@code TimeIntervalProto}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:TimeIntervalProto)
      origin.protobuf.TimeIntervalProtoOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return origin.protobuf.Protobuf.internal_static_TimeIntervalProto_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return origin.protobuf.Protobuf.internal_static_TimeIntervalProto_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              origin.protobuf.TimeIntervalProto.class, origin.protobuf.TimeIntervalProto.Builder.class);
    }

    // Construct using origin.protobuf.TimeIntervalProto.newBuilder()
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
    public Builder clear() {
      super.clear();
      startDate_ = "";

      finishDate_ = "";

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return origin.protobuf.Protobuf.internal_static_TimeIntervalProto_descriptor;
    }

    public origin.protobuf.TimeIntervalProto getDefaultInstanceForType() {
      return origin.protobuf.TimeIntervalProto.getDefaultInstance();
    }

    public origin.protobuf.TimeIntervalProto build() {
      origin.protobuf.TimeIntervalProto result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public origin.protobuf.TimeIntervalProto buildPartial() {
      origin.protobuf.TimeIntervalProto result = new origin.protobuf.TimeIntervalProto(this);
      result.startDate_ = startDate_;
      result.finishDate_ = finishDate_;
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.setField(field, value);
    }
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof origin.protobuf.TimeIntervalProto) {
        return mergeFrom((origin.protobuf.TimeIntervalProto)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(origin.protobuf.TimeIntervalProto other) {
      if (other == origin.protobuf.TimeIntervalProto.getDefaultInstance()) return this;
      if (!other.getStartDate().isEmpty()) {
        startDate_ = other.startDate_;
        onChanged();
      }
      if (!other.getFinishDate().isEmpty()) {
        finishDate_ = other.finishDate_;
        onChanged();
      }
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      origin.protobuf.TimeIntervalProto parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (origin.protobuf.TimeIntervalProto) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object startDate_ = "";
    /**
     * <code>string startDate = 1;</code>
     */
    public java.lang.String getStartDate() {
      java.lang.Object ref = startDate_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        startDate_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string startDate = 1;</code>
     */
    public com.google.protobuf.ByteString
        getStartDateBytes() {
      java.lang.Object ref = startDate_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        startDate_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string startDate = 1;</code>
     */
    public Builder setStartDate(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      startDate_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string startDate = 1;</code>
     */
    public Builder clearStartDate() {
      
      startDate_ = getDefaultInstance().getStartDate();
      onChanged();
      return this;
    }
    /**
     * <code>string startDate = 1;</code>
     */
    public Builder setStartDateBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      startDate_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object finishDate_ = "";
    /**
     * <code>string finishDate = 2;</code>
     */
    public java.lang.String getFinishDate() {
      java.lang.Object ref = finishDate_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        finishDate_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string finishDate = 2;</code>
     */
    public com.google.protobuf.ByteString
        getFinishDateBytes() {
      java.lang.Object ref = finishDate_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        finishDate_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string finishDate = 2;</code>
     */
    public Builder setFinishDate(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      finishDate_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string finishDate = 2;</code>
     */
    public Builder clearFinishDate() {
      
      finishDate_ = getDefaultInstance().getFinishDate();
      onChanged();
      return this;
    }
    /**
     * <code>string finishDate = 2;</code>
     */
    public Builder setFinishDateBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      finishDate_ = value;
      onChanged();
      return this;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }


    // @@protoc_insertion_point(builder_scope:TimeIntervalProto)
  }

  // @@protoc_insertion_point(class_scope:TimeIntervalProto)
  private static final origin.protobuf.TimeIntervalProto DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new origin.protobuf.TimeIntervalProto();
  }

  public static origin.protobuf.TimeIntervalProto getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<TimeIntervalProto>
      PARSER = new com.google.protobuf.AbstractParser<TimeIntervalProto>() {
    public TimeIntervalProto parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new TimeIntervalProto(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<TimeIntervalProto> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<TimeIntervalProto> getParserForType() {
    return PARSER;
  }

  public origin.protobuf.TimeIntervalProto getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
