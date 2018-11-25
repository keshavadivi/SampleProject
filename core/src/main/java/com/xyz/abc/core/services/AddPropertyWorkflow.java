package com.xyz.abc.core.services;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;

import com.day.cq.workflow.WorkflowException;
import com.day.cq.workflow.WorkflowSession;
import com.day.cq.workflow.exec.WorkItem;
import com.day.cq.workflow.exec.WorkflowData;
import com.day.cq.workflow.exec.WorkflowProcess;
import com.day.cq.workflow.metadata.MetaDataMap;


@Component
@Service
public class AddPropertyWorkflow implements WorkflowProcess{
@Reference 
SampleServiceInt service;
	@Override
	public void execute(WorkItem wItem, WorkflowSession wSession, MetaDataMap map) throws WorkflowException {
		// TODO Auto-generated method stub
		WorkflowData wData = wItem.getWorkflowData();
		String path = wData.getPayload().toString();
service.adProperty(path);		
	}

}
