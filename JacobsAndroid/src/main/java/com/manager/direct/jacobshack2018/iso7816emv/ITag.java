package com.manager.direct.jacobshack2018.iso7816emv;

import com.manager.direct.jacobshack2018.enums.TagTypeEnum;
import com.manager.direct.jacobshack2018.enums.TagValueTypeEnum;

public interface ITag {

	enum Class {
		UNIVERSAL, APPLICATION, CONTEXT_SPECIFIC, PRIVATE
	}

	boolean isConstructed();

	byte[] getTagBytes();

	String getName();

	String getDescription();

	TagTypeEnum getType();

	TagValueTypeEnum getTagValueType();

	Class getTagClass();

	int getNumTagBytes();

}
