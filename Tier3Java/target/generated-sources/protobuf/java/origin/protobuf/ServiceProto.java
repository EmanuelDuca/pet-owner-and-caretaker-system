// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: protobuf.proto

package origin.protobuf;

/**
 * Protobuf type {@code ServiceProto}
 */
public  final class ServiceProto extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:ServiceProto)
    ServiceProtoOrBuilder {
  // Use ServiceProto.newBuilder() to construct.
  private ServiceProto(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ServiceProto() {
    caretakerEmail_ = "";
    petOwnerEmail_ = "";
    status_ = 0;
    id_ = 0;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private ServiceProto(
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
            origin.protobuf.AnnouncementProto.Builder subBuilder = null;
            if (announcement_ != null) {
              subBuilder = announcement_.toBuilder();
            }
            announcement_ = input.readMessage(origin.protobuf.AnnouncementProto.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(announcement_);
              announcement_ = subBuilder.buildPartial();
            }

            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            caretakerEmail_ = s;
            break;
          }
          case 26: {
            java.lang.String s = input.readStringRequireUtf8();

            petOwnerEmail_ = s;
            break;
          }
          case 32: {
            int rawValue = input.readEnum();

            status_ = rawValue;
            break;
          }
          case 40: {

            id_ = input.readInt32();
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
    return origin.protobuf.Protobuf.internal_static_ServiceProto_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return origin.protobuf.Protobuf.internal_static_ServiceProto_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            origin.protobuf.ServiceProto.class, origin.protobuf.ServiceProto.Builder.class);
  }

  /**
   * Protobuf enum {@code ServiceProto.Status}
   */
  public enum Status
      implements com.google.protobuf.ProtocolMessageEnum {
    /**
     * <code>PLANNED = 0;</code>
     */
    PLANNED(0),
    /**
     * <code>IN_PROGRESS = 1;</code>
     */
    IN_PROGRESS(1),
    /**
     * <code>DONE = 2;</code>
     */
    DONE(2),
    UNRECOGNIZED(-1),
    ;

    /**
     * <code>PLANNED = 0;</code>
     */
    public static final int PLANNED_VALUE = 0;
    /**
     * <code>IN_PROGRESS = 1;</code>
     */
    public static final int IN_PROGRESS_VALUE = 1;
    /**
     * <code>DONE = 2;</code>
     */
    public static final int DONE_VALUE = 2;


    public final int getNumber() {
      if (this == UNRECOGNIZED) {
        throw new java.lang.IllegalArgumentException(
            "Can't get the number of an unknown enum value.");
      }
      return value;
    }

    /**
     * @deprecated Use {@link #forNumber(int)} instead.
     */
    @java.lang.Deprecated
    public static Status valueOf(int value) {
      return forNumber(value);
    }

    public static Status forNumber(int value) {
      switch (value) {
        case 0: return PLANNED;
        case 1: return IN_PROGRESS;
        case 2: return DONE;
        default: return null;
      }
    }

    public static com.google.protobuf.Internal.EnumLiteMap<Status>
        internalGetValueMap() {
      return internalValueMap;
    }
    private static final com.google.protobuf.Internal.EnumLiteMap<
        Status> internalValueMap =
          new com.google.protobuf.Internal.EnumLiteMap<Status>() {
            public Status findValueByNumber(int number) {
              return Status.forNumber(number);
            }
          };

    public final com.google.protobuf.Descriptors.EnumValueDescriptor
        getValueDescriptor() {
      return getDescriptor().getValues().get(ordinal());
    }
    public final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptorForType() {
      return getDescriptor();
    }
    public static final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptor() {
      return origin.protobuf.ServiceProto.getDescriptor().getEnumTypes().get(0);
    }

    private static final Status[] VALUES = values();

    public static Status valueOf(
        com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
      if (desc.getType() != getDescriptor()) {
        throw new java.lang.IllegalArgumentException(
          "EnumValueDescriptor is not for this type.");
      }
      if (desc.getIndex() == -1) {
        return UNRECOGNIZED;
      }
      return VALUES[desc.getIndex()];
    }

    private final int value;

    private Status(int value) {
      this.value = value;
    }

    // @@protoc_insertion_point(enum_scope:ServiceProto.Status)
  }

  public static final int ANNOUNCEMENT_FIELD_NUMBER = 1;
  private origin.protobuf.AnnouncementProto announcement_;
  /**
   * <code>.AnnouncementProto announcement = 1;</code>
   */
  public boolean hasAnnouncement() {
    return announcement_ != null;
  }
  /**
   * <code>.AnnouncementProto announcement = 1;</code>
   */
  public origin.protobuf.AnnouncementProto getAnnouncement() {
    return announcement_ == null ? origin.protobuf.AnnouncementProto.getDefaultInstance() : announcement_;
  }
  /**
   * <code>.AnnouncementProto announcement = 1;</code>
   */
  public origin.protobuf.AnnouncementProtoOrBuilder getAnnouncementOrBuilder() {
    return getAnnouncement();
  }

  public static final int CARETAKEREMAIL_FIELD_NUMBER = 2;
  private volatile java.lang.Object caretakerEmail_;
  /**
   * <code>string caretakerEmail = 2;</code>
   */
  public java.lang.String getCaretakerEmail() {
    java.lang.Object ref = caretakerEmail_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      caretakerEmail_ = s;
      return s;
    }
  }
  /**
   * <code>string caretakerEmail = 2;</code>
   */
  public com.google.protobuf.ByteString
      getCaretakerEmailBytes() {
    java.lang.Object ref = caretakerEmail_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      caretakerEmail_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int PETOWNEREMAIL_FIELD_NUMBER = 3;
  private volatile java.lang.Object petOwnerEmail_;
  /**
   * <code>string petOwnerEmail = 3;</code>
   */
  public java.lang.String getPetOwnerEmail() {
    java.lang.Object ref = petOwnerEmail_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      petOwnerEmail_ = s;
      return s;
    }
  }
  /**
   * <code>string petOwnerEmail = 3;</code>
   */
  public com.google.protobuf.ByteString
      getPetOwnerEmailBytes() {
    java.lang.Object ref = petOwnerEmail_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      petOwnerEmail_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int STATUS_FIELD_NUMBER = 4;
  private int status_;
  /**
   * <code>.ServiceProto.Status status = 4;</code>
   */
  public int getStatusValue() {
    return status_;
  }
  /**
   * <code>.ServiceProto.Status status = 4;</code>
   */
  public origin.protobuf.ServiceProto.Status getStatus() {
    origin.protobuf.ServiceProto.Status result = origin.protobuf.ServiceProto.Status.valueOf(status_);
    return result == null ? origin.protobuf.ServiceProto.Status.UNRECOGNIZED : result;
  }

  public static final int ID_FIELD_NUMBER = 5;
  private int id_;
  /**
   * <code>int32 id = 5;</code>
   */
  public int getId() {
    return id_;
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
    if (announcement_ != null) {
      output.writeMessage(1, getAnnouncement());
    }
    if (!getCaretakerEmailBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, caretakerEmail_);
    }
    if (!getPetOwnerEmailBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, petOwnerEmail_);
    }
    if (status_ != origin.protobuf.ServiceProto.Status.PLANNED.getNumber()) {
      output.writeEnum(4, status_);
    }
    if (id_ != 0) {
      output.writeInt32(5, id_);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (announcement_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getAnnouncement());
    }
    if (!getCaretakerEmailBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, caretakerEmail_);
    }
    if (!getPetOwnerEmailBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, petOwnerEmail_);
    }
    if (status_ != origin.protobuf.ServiceProto.Status.PLANNED.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(4, status_);
    }
    if (id_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(5, id_);
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
    if (!(obj instanceof origin.protobuf.ServiceProto)) {
      return super.equals(obj);
    }
    origin.protobuf.ServiceProto other = (origin.protobuf.ServiceProto) obj;

    boolean result = true;
    result = result && (hasAnnouncement() == other.hasAnnouncement());
    if (hasAnnouncement()) {
      result = result && getAnnouncement()
          .equals(other.getAnnouncement());
    }
    result = result && getCaretakerEmail()
        .equals(other.getCaretakerEmail());
    result = result && getPetOwnerEmail()
        .equals(other.getPetOwnerEmail());
    result = result && status_ == other.status_;
    result = result && (getId()
        == other.getId());
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (hasAnnouncement()) {
      hash = (37 * hash) + ANNOUNCEMENT_FIELD_NUMBER;
      hash = (53 * hash) + getAnnouncement().hashCode();
    }
    hash = (37 * hash) + CARETAKEREMAIL_FIELD_NUMBER;
    hash = (53 * hash) + getCaretakerEmail().hashCode();
    hash = (37 * hash) + PETOWNEREMAIL_FIELD_NUMBER;
    hash = (53 * hash) + getPetOwnerEmail().hashCode();
    hash = (37 * hash) + STATUS_FIELD_NUMBER;
    hash = (53 * hash) + status_;
    hash = (37 * hash) + ID_FIELD_NUMBER;
    hash = (53 * hash) + getId();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static origin.protobuf.ServiceProto parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static origin.protobuf.ServiceProto parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static origin.protobuf.ServiceProto parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static origin.protobuf.ServiceProto parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static origin.protobuf.ServiceProto parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static origin.protobuf.ServiceProto parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static origin.protobuf.ServiceProto parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static origin.protobuf.ServiceProto parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static origin.protobuf.ServiceProto parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static origin.protobuf.ServiceProto parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static origin.protobuf.ServiceProto parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static origin.protobuf.ServiceProto parseFrom(
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
  public static Builder newBuilder(origin.protobuf.ServiceProto prototype) {
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
   * Protobuf type {@code ServiceProto}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:ServiceProto)
      origin.protobuf.ServiceProtoOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return origin.protobuf.Protobuf.internal_static_ServiceProto_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return origin.protobuf.Protobuf.internal_static_ServiceProto_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              origin.protobuf.ServiceProto.class, origin.protobuf.ServiceProto.Builder.class);
    }

    // Construct using origin.protobuf.ServiceProto.newBuilder()
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
      if (announcementBuilder_ == null) {
        announcement_ = null;
      } else {
        announcement_ = null;
        announcementBuilder_ = null;
      }
      caretakerEmail_ = "";

      petOwnerEmail_ = "";

      status_ = 0;

      id_ = 0;

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return origin.protobuf.Protobuf.internal_static_ServiceProto_descriptor;
    }

    public origin.protobuf.ServiceProto getDefaultInstanceForType() {
      return origin.protobuf.ServiceProto.getDefaultInstance();
    }

    public origin.protobuf.ServiceProto build() {
      origin.protobuf.ServiceProto result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public origin.protobuf.ServiceProto buildPartial() {
      origin.protobuf.ServiceProto result = new origin.protobuf.ServiceProto(this);
      if (announcementBuilder_ == null) {
        result.announcement_ = announcement_;
      } else {
        result.announcement_ = announcementBuilder_.build();
      }
      result.caretakerEmail_ = caretakerEmail_;
      result.petOwnerEmail_ = petOwnerEmail_;
      result.status_ = status_;
      result.id_ = id_;
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
      if (other instanceof origin.protobuf.ServiceProto) {
        return mergeFrom((origin.protobuf.ServiceProto)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(origin.protobuf.ServiceProto other) {
      if (other == origin.protobuf.ServiceProto.getDefaultInstance()) return this;
      if (other.hasAnnouncement()) {
        mergeAnnouncement(other.getAnnouncement());
      }
      if (!other.getCaretakerEmail().isEmpty()) {
        caretakerEmail_ = other.caretakerEmail_;
        onChanged();
      }
      if (!other.getPetOwnerEmail().isEmpty()) {
        petOwnerEmail_ = other.petOwnerEmail_;
        onChanged();
      }
      if (other.status_ != 0) {
        setStatusValue(other.getStatusValue());
      }
      if (other.getId() != 0) {
        setId(other.getId());
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
      origin.protobuf.ServiceProto parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (origin.protobuf.ServiceProto) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private origin.protobuf.AnnouncementProto announcement_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        origin.protobuf.AnnouncementProto, origin.protobuf.AnnouncementProto.Builder, origin.protobuf.AnnouncementProtoOrBuilder> announcementBuilder_;
    /**
     * <code>.AnnouncementProto announcement = 1;</code>
     */
    public boolean hasAnnouncement() {
      return announcementBuilder_ != null || announcement_ != null;
    }
    /**
     * <code>.AnnouncementProto announcement = 1;</code>
     */
    public origin.protobuf.AnnouncementProto getAnnouncement() {
      if (announcementBuilder_ == null) {
        return announcement_ == null ? origin.protobuf.AnnouncementProto.getDefaultInstance() : announcement_;
      } else {
        return announcementBuilder_.getMessage();
      }
    }
    /**
     * <code>.AnnouncementProto announcement = 1;</code>
     */
    public Builder setAnnouncement(origin.protobuf.AnnouncementProto value) {
      if (announcementBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        announcement_ = value;
        onChanged();
      } else {
        announcementBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.AnnouncementProto announcement = 1;</code>
     */
    public Builder setAnnouncement(
        origin.protobuf.AnnouncementProto.Builder builderForValue) {
      if (announcementBuilder_ == null) {
        announcement_ = builderForValue.build();
        onChanged();
      } else {
        announcementBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.AnnouncementProto announcement = 1;</code>
     */
    public Builder mergeAnnouncement(origin.protobuf.AnnouncementProto value) {
      if (announcementBuilder_ == null) {
        if (announcement_ != null) {
          announcement_ =
            origin.protobuf.AnnouncementProto.newBuilder(announcement_).mergeFrom(value).buildPartial();
        } else {
          announcement_ = value;
        }
        onChanged();
      } else {
        announcementBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.AnnouncementProto announcement = 1;</code>
     */
    public Builder clearAnnouncement() {
      if (announcementBuilder_ == null) {
        announcement_ = null;
        onChanged();
      } else {
        announcement_ = null;
        announcementBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.AnnouncementProto announcement = 1;</code>
     */
    public origin.protobuf.AnnouncementProto.Builder getAnnouncementBuilder() {
      
      onChanged();
      return getAnnouncementFieldBuilder().getBuilder();
    }
    /**
     * <code>.AnnouncementProto announcement = 1;</code>
     */
    public origin.protobuf.AnnouncementProtoOrBuilder getAnnouncementOrBuilder() {
      if (announcementBuilder_ != null) {
        return announcementBuilder_.getMessageOrBuilder();
      } else {
        return announcement_ == null ?
            origin.protobuf.AnnouncementProto.getDefaultInstance() : announcement_;
      }
    }
    /**
     * <code>.AnnouncementProto announcement = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        origin.protobuf.AnnouncementProto, origin.protobuf.AnnouncementProto.Builder, origin.protobuf.AnnouncementProtoOrBuilder> 
        getAnnouncementFieldBuilder() {
      if (announcementBuilder_ == null) {
        announcementBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            origin.protobuf.AnnouncementProto, origin.protobuf.AnnouncementProto.Builder, origin.protobuf.AnnouncementProtoOrBuilder>(
                getAnnouncement(),
                getParentForChildren(),
                isClean());
        announcement_ = null;
      }
      return announcementBuilder_;
    }

    private java.lang.Object caretakerEmail_ = "";
    /**
     * <code>string caretakerEmail = 2;</code>
     */
    public java.lang.String getCaretakerEmail() {
      java.lang.Object ref = caretakerEmail_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        caretakerEmail_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string caretakerEmail = 2;</code>
     */
    public com.google.protobuf.ByteString
        getCaretakerEmailBytes() {
      java.lang.Object ref = caretakerEmail_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        caretakerEmail_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string caretakerEmail = 2;</code>
     */
    public Builder setCaretakerEmail(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      caretakerEmail_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string caretakerEmail = 2;</code>
     */
    public Builder clearCaretakerEmail() {
      
      caretakerEmail_ = getDefaultInstance().getCaretakerEmail();
      onChanged();
      return this;
    }
    /**
     * <code>string caretakerEmail = 2;</code>
     */
    public Builder setCaretakerEmailBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      caretakerEmail_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object petOwnerEmail_ = "";
    /**
     * <code>string petOwnerEmail = 3;</code>
     */
    public java.lang.String getPetOwnerEmail() {
      java.lang.Object ref = petOwnerEmail_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        petOwnerEmail_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string petOwnerEmail = 3;</code>
     */
    public com.google.protobuf.ByteString
        getPetOwnerEmailBytes() {
      java.lang.Object ref = petOwnerEmail_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        petOwnerEmail_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string petOwnerEmail = 3;</code>
     */
    public Builder setPetOwnerEmail(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      petOwnerEmail_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string petOwnerEmail = 3;</code>
     */
    public Builder clearPetOwnerEmail() {
      
      petOwnerEmail_ = getDefaultInstance().getPetOwnerEmail();
      onChanged();
      return this;
    }
    /**
     * <code>string petOwnerEmail = 3;</code>
     */
    public Builder setPetOwnerEmailBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      petOwnerEmail_ = value;
      onChanged();
      return this;
    }

    private int status_ = 0;
    /**
     * <code>.ServiceProto.Status status = 4;</code>
     */
    public int getStatusValue() {
      return status_;
    }
    /**
     * <code>.ServiceProto.Status status = 4;</code>
     */
    public Builder setStatusValue(int value) {
      status_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>.ServiceProto.Status status = 4;</code>
     */
    public origin.protobuf.ServiceProto.Status getStatus() {
      origin.protobuf.ServiceProto.Status result = origin.protobuf.ServiceProto.Status.valueOf(status_);
      return result == null ? origin.protobuf.ServiceProto.Status.UNRECOGNIZED : result;
    }
    /**
     * <code>.ServiceProto.Status status = 4;</code>
     */
    public Builder setStatus(origin.protobuf.ServiceProto.Status value) {
      if (value == null) {
        throw new NullPointerException();
      }
      
      status_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>.ServiceProto.Status status = 4;</code>
     */
    public Builder clearStatus() {
      
      status_ = 0;
      onChanged();
      return this;
    }

    private int id_ ;
    /**
     * <code>int32 id = 5;</code>
     */
    public int getId() {
      return id_;
    }
    /**
     * <code>int32 id = 5;</code>
     */
    public Builder setId(int value) {
      
      id_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 id = 5;</code>
     */
    public Builder clearId() {
      
      id_ = 0;
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


    // @@protoc_insertion_point(builder_scope:ServiceProto)
  }

  // @@protoc_insertion_point(class_scope:ServiceProto)
  private static final origin.protobuf.ServiceProto DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new origin.protobuf.ServiceProto();
  }

  public static origin.protobuf.ServiceProto getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ServiceProto>
      PARSER = new com.google.protobuf.AbstractParser<ServiceProto>() {
    public ServiceProto parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new ServiceProto(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<ServiceProto> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ServiceProto> getParserForType() {
    return PARSER;
  }

  public origin.protobuf.ServiceProto getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

