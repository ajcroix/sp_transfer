package com.surepass.service;

import java.beans.PropertyVetoException;
import java.io.IOException;

import org.springframework.stereotype.Service;

import com.ibm.as400.access.AS400;
import com.ibm.as400.access.AS400Message;
import com.ibm.as400.access.AS400SecurityException;
import com.ibm.as400.access.AS400Text;
import com.ibm.as400.access.ErrorCompletingRequestException;
import com.ibm.as400.access.ObjectDoesNotExistException;
import com.ibm.as400.access.ProgramCall;
import com.ibm.as400.access.ProgramParameter;
import com.ibm.as400.access.QSYSObjectPathName;

@Service
public class AS400Service {

	private static final String CCSID = "IBM285";
	private static final String HOST = "66.186.183.116";
	private static final String UID = "ECOUSER";
	private static final String PWD = "ECOUSER";
	private static final String LIB = "ECOINVLIB";
	private String PGM = "TFR0001C";

	private void callAS400PGM(String values) {
		String fullProgramName = QSYSObjectPathName.toPath(LIB, PGM, "PGM");
		AS400 as400 = null;
		ProgramParameter[] programParameters = null;

		try {
			as400 = new AS400(HOST, UID, PWD);
			System.out.println("Connected to AS400");
			
			ProgramCall programCall = new ProgramCall(as400);

			programParameters = new ProgramParameter[1];			
			AS400Text parm1 = new AS400Text(70, as400);
			programParameters[0] = new ProgramParameter(parm1.toBytes(values));
			
			String msgIn = (String) parm1.toObject(programParameters[0].getInputData());
			System.out.println(msgIn);
			programCall.setProgram(fullProgramName, programParameters);
			if (!programCall.run()) {
				AS400Message[] messageList = programCall.getMessageList();
				for (AS400Message message : messageList) {
					System.err.println(message.getID() + " - " + message.getText());
				} 
			} else {
				System.out.println(programParameters[0].toString());
			}
			
		} catch (PropertyVetoException | AS400SecurityException | ErrorCompletingRequestException | IOException
				| InterruptedException | ObjectDoesNotExistException e) {
			System.err.println(":: Exception ::" + e.toString());
			
		} finally {
			try {
				// Make sure to disconnect
				if (as400 != null) {
					as400.disconnectAllServices();
					System.out.println("Disconnected to AS400");
				}
			} catch (Exception e) {
				System.err.println(":: Exception ::" + e.toString());
			}
		}
	}

	public void sendToAS400(String value) {
		callAS400PGM(value);
	}
}