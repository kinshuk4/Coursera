/*
 * Copyright 2003 by Michael Niedermair and 2007 Bruno Lowagie.
 *
 * The contents of this file are subject to the Mozilla Public License Version 1.1
 * (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.mozilla.org/MPL/
 *
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License
 * for the specific language governing rights and limitations under the License.
 *
 * The Original Code is 'iText, a free JAVA-PDF library'.
 *
 * The Initial Developer of the Original Code is Bruno Lowagie. Portions created by
 * the Initial Developer are Copyright (C) 1999, 2000, 2001, 2002 by Bruno Lowagie.
 * All Rights Reserved.
 * Co-Developer of the code is Paulo Soares. Portions created by the Co-Developer
 * are Copyright (C) 2000, 2001, 2002 by Paulo Soares. All Rights Reserved.
 *
 * Contributor(s): all the names of the contributors are added in the source code
 * where applicable.
 *
 * Alternatively, the contents of this file may be used under the terms of the
 * LGPL license (the "GNU LIBRARY GENERAL PUBLIC LICENSE"), in which case the
 * provisions of LGPL are applicable instead of those above.  If you wish to
 * allow use of your version of this file only under the terms of the LGPL
 * License and not to allow others to use your version of this file under
 * the MPL, indicate your decision by deleting the provisions above and
 * replace them with the notice and other provisions required by the LGPL.
 * If you do not delete the provisions above, a recipient may use your version
 * of this file under either the MPL or the GNU LIBRARY GENERAL PUBLIC LICENSE.
 *
 * This library is free software; you can redistribute it and/or modify it
 * under the terms of the MPL as stated above or under the terms of the GNU
 * Library General Public License as published by the Free Software Foundation;
 * either version 2 of the License, or any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Library general Public License for more
 * details.
 *
 * If you didn't download this code from the following link, you should check if
 * you aren't using an obsolete version:
 * http://www.lowagie.com/iText/
 */
package com.lowagie.text;

import com.lowagie.text.factories.RomanNumberFactory;

/**
 * 
 * A special-version of <CODE>LIST</CODE> which use roman-letters.
 * 
 * @see com.lowagie.text.List
 */

public class RomanList extends List {

// constructors
	
	/**
	 * Initialization
	 */
	public RomanList() {
		super(true);
	}

	/**
	 * Initialization
	 * 
	 * @param symbolIndent	indent
	 */
	public RomanList(int symbolIndent) {
		super(true, symbolIndent);
	}

	/**
	 * Initialization 
	 * @param	lowercase		roman-char in lowercase   
	 * @param 	symbolIndent	indent
	 */
	public RomanList(boolean lowercase, int symbolIndent) {
		super(true, symbolIndent);
		this.lowercase = lowercase;
	}

// overridden method
	
	/**
	 * Adds an <CODE>Object</CODE> to the <CODE>List</CODE>.
	 *
	 * @param	o	the object to add.
	 * @return true if adding the object succeeded
	 */
	public boolean add(Object o) {
		if (o instanceof ListItem) {
			ListItem item = (ListItem) o;
			Chunk chunk;
			chunk = new Chunk(RomanNumberFactory.getString(first + list.size(), lowercase), symbol.getFont());
			chunk.append(". ");
			item.setListSymbol(chunk);
			item.setIndentationLeft(symbolIndent, autoindent);
			item.setIndentationRight(0);
			list.add(item);
		} else if (o instanceof List) {
			List nested = (List) o;
			nested.setIndentationLeft(nested.getIndentationLeft() + symbolIndent);
			first--;
			return list.add(nested);
		} else if (o instanceof String) {
			return this.add(new ListItem((String) o));
		}
		return false;
	}
	
// deprecated methods
	
	/**
	 * @deprecated use RomanNumberFactory.getString(int)
	 */
	public static String toRoman(int number) {
		return RomanNumberFactory.getString(number);
	}
	/**
	 * @deprecated use RomanNumberFactory.getString(int, boolean)
	 */
	public static String toRomanLowerCase(int number) {
		return RomanNumberFactory.getString(number, true);
	}
	/**
	 * @deprecated use RomanNumberFactory.getString(int, boolean)
	 */
	public static String toRomanUpperCase(int number) {
		return RomanNumberFactory.getString(number, false);
	}

	/**
	 * set the roman-letters to lowercase otherwise to uppercase
	 * 
	 * @param romanlower
	 * @deprecated use setLowercase(boolean)
	 */
	public void setRomanLower(boolean romanlower) {
		setLowercase(romanlower);
	}

	/**
	 * Checks if the list is roman-letter with lowercase
	 *
	 * @return	<CODE>true</CODE> if the roman-letter is lowercase, <CODE>false</CODE> otherwise.
	 * @deprecated use isLowercase()
	 */
	public boolean isRomanLower() {
		return isLowercase();
	}
}