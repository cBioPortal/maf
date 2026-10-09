/*
 * Copyright (c) 2015 Memorial Sloan-Kettering Cancer Center.
 *
 * SPDX-License-Identifier: Apache-2.0
 */

package org.mskcc.cbio.maf;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class to process comment lines (meta data) of a standard text file.
 * Default comment line indicator is #
 *
 * @author Selcuk Onur Sumer
 */
public class MafHeaderUtil
{
	public static final String DEFAULT_COMMENT_CHAR = "#";

	private String headerLine;
	private List<String> comments;
	private String commentChar;

	public MafHeaderUtil(String commentChar)
	{
		this.comments = new ArrayList<String>();
		this.headerLine = null;
		this.commentChar = commentChar;
	}

	public MafHeaderUtil()
	{
		this(DEFAULT_COMMENT_CHAR);
	}

	public String extractHeader(BufferedReader reader) throws IOException
	{
		String line;
		boolean done = false;

		while (!done)
		{
			line = reader.readLine();

			if (line == null ||
			    (line.trim().length() > 0) && !line.trim().startsWith(this.commentChar))
			{
				done = true;
				this.headerLine = line;
			}
			else
			{
				this.comments.add(line);
			}
		}

		return this.headerLine;
	}

	public List<String> getComments()
	{
		return comments;
	}

	public String getHeaderLine()
	{
		return headerLine;
	}
}
