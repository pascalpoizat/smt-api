/**
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * <p/>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p/>
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 * <p/>
 * {description}
 * Copyright (C) 2013 Abderrahmane Feliachi, Université Paris Sud
 * contact: https://plus.google.com/112309258396642297676/posts
 * email: tbd
 */

package xsmt.response;

public class BasicResponse implements IResponse {

	String text;
	
	public BasicResponse(String text) {
		super();
		this.text = text;
	}

	public String toString(){
		return text;
	}
	
}