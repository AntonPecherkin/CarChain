package com.manager.direct.jacobshack2018.parser.apdu;


import com.manager.direct.jacobshack2018.iso7816emv.TagAndLength;

import java.util.List;

/**
 * Interface for File to parse
 */
public interface IFile {

	/**
	 * Method to parse byte data
	 * 
	 * @param pData
	 *            byte to parse
	 * @param pList
	 *            Tag and length
	 */
	void parse(final byte[] pData, final List<TagAndLength> pList);

}
