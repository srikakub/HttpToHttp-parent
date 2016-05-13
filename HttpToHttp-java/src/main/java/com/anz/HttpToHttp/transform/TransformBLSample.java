/**
 * 
 */
package com.anz.HttpToHttp.transform;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.anz.HttpToHttp.transform.pojo.NumbersInput;
import com.anz.common.compute.ComputeInfo;
import com.anz.common.transform.ITransformer;
import com.anz.common.transform.TransformUtils;


/**
 * @author sanketsw
 * 
 */
public class TransformBLSample implements ITransformer<String, String> {
	
	private static final Logger logger = LogManager.getLogger();

	
	/* (non-Javadoc)
	 * @see com.anz.common.transform.IJsonJsonTransformer#execute(java.lang.String)
	 */
	public String execute(String inputJson, Logger appLogger, ComputeInfo metadata) throws Exception {
		
		appLogger.info("{}: Request: {}", this.getClass().getName(), inputJson);
		
		NumbersInput json = (NumbersInput) TransformUtils.fromJSON(inputJson,
				NumbersInput.class);
		
		json.setLeft(json.getLeft() + 100);
		
		logger.info("Accessing message flow level user defined property: {}", metadata.getUserDefinedProperties().get("HTTP_URL"));
		
		String out = TransformUtils.toJSON(json);
		return out;
	}


}
