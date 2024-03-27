import PieChartCard from "views/documents/components/PieChartCard";
import { columnsDataComplex } from "views/documents/variables/columnsData";

import ComplexTable from "views/documents/components/ComplexTable";
import { useEffect, useState } from "react";

const Documents = () => {
  const [claimData, setClaimData] = useState([]);
  const [policyData, setPolicyData] = useState([]);
  const [billingData, setBillingData] = useState([]);
  const [claimSum,setClaimSum]= useState(0);
  const [policySum,setPolicySum]= useState(0);
  const [billingSum,setBillingSum]= useState(0);
  const [policyError,setPolicyError]= useState(0);
  const [claimError,setClaimError]= useState(0);
  const [billingError,setBillingError]= useState(0);
  const [documentData,setDocumentmData] = useState([]);
  let [center,setCenter]=useState("All services");
  let [status,setStatus]=useState("All status");
  let[field,setField]=useState("");
  useEffect(() => {
    // Function to fetch data from the backend
    const fetchData = async () => {
      try {
        const response = await fetch("http://localhost:8080/document/get/Numbers/start=2024-03-18 10:50:42.000000&end=2024-03-21 13:13:16.000000");
        if (!response.ok) {
          throw new Error('Failed to fetch data');
        }
        const jsonData = await response.json();
        setClaimData(jsonData.claim);
        setPolicyData(jsonData.policy);
        setBillingData(jsonData.billing);
        setPolicyError(jsonData.error[0]);
        setClaimError(jsonData.error[2]);
        setBillingError(jsonData.error[1]);
        setPolicySum(jsonData.sum[0]);
        setBillingSum(jsonData.sum[1]);
        setClaimSum(jsonData.sum[2]);
      } catch (error) {
        console.error('Error fetching data:', error);
      }
      try {
      const response = await fetch("http://localhost:8080/document/get/all/pageNumber=0&pageSize=8");
        if (!response.ok) {
          throw new Error('Failed to fetch data');
        }
        const jsonData = await response.json();
        setDocumentmData(jsonData);
        
      } catch (error) {
        console.error('Error fetching data:', error);
      }
    };

    fetchData();
    
  }, []);
  async function filterByCenter(center) {
    setCenter(center);
    if(center=='All centers'){
      if(status=="All status"){
        try {
          const response = await fetch("http://localhost:8080/document/get/all/pageNumber=0&pageSize=8");
            if (!response.ok) {
              throw new Error('Failed to fetch data');
            }
            const jsonData = await response.json();
  
            setDocumentmData(jsonData);
            
          } catch (error) {
            console.error('Error fetching data:', error);
          }
      }else{
        try {
          const response = await fetch("http://localhost:8080/document/get/all/pageNumber=0&pageSize=8");
            if (!response.ok) {
              throw new Error('Failed to fetch data');
            }
            const jsonData = await response.json();
            const data=jsonData.filter(obj1 =>
              documentData.some(obj2 => obj1.status === obj2.status)
            );
            setDocumentmData(data);
            
          } catch (error) {
            console.error('Error fetching data:', error);
          }
      };
      
    }else{
      if(status=="All status"){
        try {
          const response = await fetch("http://localhost:8080/document/get/service="+center);
            if (!response.ok) {
              throw new Error('Failed to fetch data');
            }
            const jsonData = await response.json();
            setDocumentmData(jsonData);
          } catch (error) {
            console.error('Error fetching data:', error);
          }
      }else{
        try {
          const response = await fetch("http://localhost:8080/document/get/service="+center);
            if (!response.ok) {
              throw new Error('Failed to fetch data');
            }
            const jsonData = await response.json();
            const data=jsonData.filter(obj1 =>
              documentData.some(obj2 => obj1.status === obj2.status)
            );
            setDocumentmData(data);
          } catch (error) {
            console.error('Error fetching data:', error);
          }
      };
      
    }
  }
  async function filterByStatus(status) {
    setStatus(status);
    if (status=="All status"){
      try {
        const response = await fetch("http://localhost:8080/document/get/all/pageNumber=0&pageSize=8");
          if (!response.ok) {
            throw new Error('Failed to fetch data');
          }
          const jsonData = await response.json();
          if (center!="All services"){
            const responseC = await fetch("http://localhost:8080/document/get/service="+center);
            const jsonDataC = await responseC.json();
            const data=jsonData.filter(obj1 =>
              jsonDataC.some(obj2 => obj1.service === obj2.service)
            );
            setDocumentmData(data);
          }else{
            setDocumentmData(jsonData);
          }
        } catch (error) {
          console.error('Error fetching data:', error);
        }
    }else{
      try {
        const response = await fetch("http://localhost:8080/document/get/status="+status);
          if (!response.ok) {
            throw new Error('Failed to fetch data');
          }
          const jsonData = await response.json();
          if (center!="All services"){
            const responseC = await fetch("http://localhost:8080/document/get/service="+center);
            const jsonDataC = await responseC.json();
            const data=jsonData.filter(obj1 =>
              jsonDataC.some(obj2 => obj1.service === obj2.service)
            );
            setDocumentmData(data);
          }else{
            setDocumentmData(jsonData);
          }} catch (error) {
          console.error('Error fetching data:', error);
        }
    }
    
  }
  async function filterByField(field){
    setField(field);
    if (field.startsWith("cc:") || field.startsWith("pc:")||field.startsWith("bc:")){
      try {
        const response = await fetch("http://localhost:8080/document/get/id="+field);
          if (!response.ok) {
            throw new Error('Failed to fetch data');
          }
          const jsonData = await response.json();
          setDocumentmData([jsonData]);
        } catch (error) {
          console.error('Error fetching data:', error);
        }
    }else if (field==""){
      try {
        const response = await fetch("http://localhost:8080/document/get/all/pageNumber=0&pageSize=8");
          if (!response.ok) {
            throw new Error('Failed to fetch data');
          }
          const jsonData = await response.json();
          setDocumentmData(jsonData);
          
        } catch (error) {
          console.error('Error fetching data:', error);
        }
    }else{
      try {
        
        const response = await fetch("http://localhost:8080/document/get/GW_ID="+field);
          if (!response.ok) {
            throw new Error('Failed to fetch data');
          }
          const jsonData = await response.json();
          setDocumentmData(jsonData);
        } catch (error) {
          console.error('Error fetching data:', error);
        }
    }
  }
  async function dateFilter(dates,center){
    const start = new Date(dates[0]);
    const startIso = start.toISOString().substring(0, 10) + ' ' + start.toISOString().substring(11, 23);
    const end=new Date(dates[1]);
    const endIso = end.toISOString().substring(0, 10) + ' ' + end.toISOString().substring(11, 23);
    try {
      const response = await fetch("http://localhost:8080/document/get/Numbers/start="+startIso+"&end="+endIso);
      if (!response.ok) {
        throw new Error('Failed to fetch data');
      }
      const jsonData = await response.json();
      console.log(center);
      switch(center){
        case "Policy Center":
          setPolicyData(jsonData.policy);
          setPolicySum(jsonData.sum[0]);
          setPolicyError(jsonData.error[0]);
          break;
        case "Claim Center":
          setClaimData(jsonData.claim);
          setClaimError(jsonData.error[2]);
          setClaimSum(jsonData.sum[2]);
          break;
        case "Billing Center":
          setBillingData(jsonData.billing);
          setBillingError(jsonData.error[1]);
          setBillingSum(jsonData.sum[1]);
          break;
          
      } 
        
    } catch (error) {
      console.error('Error fetching data:', error);
    }

  }
  
  return (
    <div>
      <div className="grid grid-cols-1 gap-5 rounded-[20px] md:grid-cols-3">
          <PieChartCard name="Policy Center" data={policyData} sum = {policySum} error={policyError} sendDate={dateFilter}/>
          <PieChartCard name="Claim Center" data={claimData} sum = {claimSum} error={claimError} sendDate={dateFilter}/>
          <PieChartCard name="Billing Center" data={billingData} sum = {billingSum} error={billingError} sendDate={dateFilter}/>
        </div>
      <div className="mt-5 grid grid-cols-1 gap-5 xl:grid-cols-1">
        <div>
        <ComplexTable
          columnsData={columnsDataComplex}
          tableData={documentData}
          centerFilter={filterByCenter}
          statusFilter={filterByStatus}
          sendField={filterByField}
        />
        </div> 
      </div>
    </div>
  );
};

export default Documents;
