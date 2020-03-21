package com.telran.cars.data.dto;

import com.google.gson.annotations.SerializedName;

public class JsonNode {

    private boolean array;
    private boolean bigDecimal;
    private boolean bigInteger;
    private boolean binary;
    @SerializedName("boolean")
    private boolean bool;
    private boolean containerNode;
    @SerializedName("double")
    private boolean doub;
    private boolean empty;
    @SerializedName("float")
    private boolean fl;
    private boolean floatingPointNumber;
    @SerializedName("int")
    private boolean in;
    private boolean integralNumber;
    @SerializedName("long")
    private boolean lon;
    private boolean missingNode;
    private NodeType nodeType;
    @SerializedName("null")
    private boolean nul;
    private boolean number;
    private boolean object;
    private boolean pojo;
    @SerializedName("short")
    private boolean shor;
    private boolean textual;
    private boolean valueNode;

    public JsonNode(boolean array, boolean bigDecimal, boolean bigInteger, boolean binary, boolean bool, boolean containerNode, boolean doub, boolean empty, boolean fl, boolean floatingPointNumber, boolean in, boolean integralNumber, boolean lon, boolean missingNode, NodeType nodeType, boolean nul, boolean number, boolean object, boolean pojo, boolean shor, boolean textual, boolean valueNode) {
        this.array = array;
        this.bigDecimal = bigDecimal;
        this.bigInteger = bigInteger;
        this.binary = binary;
        this.bool = bool;
        this.containerNode = containerNode;
        this.doub = doub;
        this.empty = empty;
        this.fl = fl;
        this.floatingPointNumber = floatingPointNumber;
        this.in = in;
        this.integralNumber = integralNumber;
        this.lon = lon;
        this.missingNode = missingNode;
        this.nodeType = nodeType;
        this.nul = nul;
        this.number = number;
        this.object = object;
        this.pojo = pojo;
        this.shor = shor;
        this.textual = textual;
        this.valueNode = valueNode;
    }

    public boolean isArray() {
        return array;
    }

    public boolean isBigDecimal() {
        return bigDecimal;
    }

    public boolean isBigInteger() {
        return bigInteger;
    }

    public boolean isBinary() {
        return binary;
    }

    public boolean isBool() {
        return bool;
    }

    public boolean isContainerNode() {
        return containerNode;
    }

    public boolean isDoub() {
        return doub;
    }

    public boolean isEmpty() {
        return empty;
    }

    public boolean isFl() {
        return fl;
    }

    public boolean isFloatingPointNumber() {
        return floatingPointNumber;
    }

    public boolean isIn() {
        return in;
    }

    public boolean isIntegralNumber() {
        return integralNumber;
    }

    public boolean isLon() {
        return lon;
    }

    public boolean isMissingNode() {
        return missingNode;
    }

    public NodeType getNodeType() {
        return nodeType;
    }

    public boolean isNul() {
        return nul;
    }

    public boolean isNumber() {
        return number;
    }

    public boolean isObject() {
        return object;
    }

    public boolean isPojo() {
        return pojo;
    }

    public boolean isShor() {
        return shor;
    }

    public boolean isTextual() {
        return textual;
    }

    public boolean isValueNode() {
        return valueNode;
    }

    @Override
    public String toString() {
        return "JsonNode{" +
                "array=" + array +
                ", bigDecimal=" + bigDecimal +
                ", bigInteger=" + bigInteger +
                ", binary=" + binary +
                ", bool=" + bool +
                ", containerNode=" + containerNode +
                ", doub=" + doub +
                ", empty=" + empty +
                ", fl=" + fl +
                ", floatingPointNumber=" + floatingPointNumber +
                ", in=" + in +
                ", integralNumber=" + integralNumber +
                ", lon=" + lon +
                ", missingNode=" + missingNode +
                ", nodeType=" + nodeType +
                ", nul=" + nul +
                ", number=" + number +
                ", object=" + object +
                ", pojo=" + pojo +
                ", shor=" + shor +
                ", textual=" + textual +
                ", valueNode=" + valueNode +
                '}';
    }
}

enum NodeType {
    ARRAY,
    BINARY,
    BOOLEAN,
    MISSING,
    NULL,
    NUMBER,
    OBJECT,
    POJO,
    STRING;

    NodeType() {
    }
}
