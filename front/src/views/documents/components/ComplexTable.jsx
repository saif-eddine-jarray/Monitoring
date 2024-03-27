import CardMenu from "components/card/CardMenu";
import Card from "components/card";
import {
  useGlobalFilter,
  usePagination,
  useSortBy,
  useTable,
} from "react-table";
import { useMemo, useState } from "react";
import CardMenu1 from "components/card/CardMenu1.0";
import { FiSearch } from "react-icons/fi";
const ComplexTable = (props) => {
  const { columnsData, tableData } = props;

  const columns = useMemo(() => columnsData, [columnsData]);
  const data = useMemo(() => tableData, [tableData]);
  const [field,setField]= useState("Filter By Id/Object...")
  const tableInstance = useTable(
    {
      columns,
      data,
    },
    useGlobalFilter,
    useSortBy,
    usePagination
  );

  const {
    getTableProps,
    getTableBodyProps,
    headerGroups,
    page,
    prepareRow,
    initialState,
  } = tableInstance;
  initialState.pageSize = 7;
  function filterByCenter(centerfilter){
    props.centerFilter(centerfilter);
  }
  function filterByStatus(statusFilter){
    props.statusFilter(statusFilter);
  }
  const handleChange=(event)=>{
    setField(event.target.value);
  }
  const handleKeyDown=async (event)=>{
    if(event.key === 'Enter'){;
      props.sendField(field);
    }
  }
  return (
    <Card extra={"w-full h-full px-6 pb-6 sm:overflow-x-auto"}>
      <div class="relative flex items-center justify-between pt-4">
        <div class="text-xl font-bold text-navy-700 dark:text-white">
          All Documents
        </div>
          <CardMenu sendData={filterByCenter}/>
          <CardMenu1 sendData={filterByStatus}/>
          <div className="flex h-full items-center rounded-full bg-lightPrimary text-navy-700 dark:bg-navy-900 dark:text-white xl:w-[225px]">
            <p className="pl-3 pr-2 text-xl">
              <FiSearch className="h-4 w-4 text-gray-400 dark:text-white" />
            </p>
            <input
              type="text"
              placeholder={field}
              onChange={handleChange}
              onKeyDown={handleKeyDown}
              class="block h-full w-full rounded-full bg-lightPrimary text-sm font-medium text-navy-700 outline-none placeholder:!text-gray-400 dark:bg-navy-900 dark:text-white dark:placeholder:!text-white sm:w-fit"
            />
          </div>
      </div>

      <div class="mt-8 overflow-x-scroll xl:overflow-hidden">
        <table {...getTableProps()} className="w-full">
          <thead>
            {headerGroups.map((headerGroup, index) => (
              <tr {...headerGroup.getHeaderGroupProps()} key={index}>
                {headerGroup.headers.map((column, index) => (
                  <th
                    {...column.getHeaderProps(column.getSortByToggleProps())}
                    key={index}
                    className="border-b border-gray-200 pr-28 pb-[10px] text-start dark:!border-navy-700"
                  >
                    <p className="text-xs tracking-wide text-gray-600">
                      {column.render("Header")}
                    </p>
                  </th>
                ))}
              </tr>
            ))}
          </thead>
          <tbody {...getTableBodyProps()}>
            {page.map((row, index) => {
              prepareRow(row);
              return (
                <tr {...row.getRowProps()} key={index}>
                  {row.cells.map((cell, index) => {
                    let data = "";
                    if (cell.column.Header === "TimeStamp") {
                      data = (
                        <p className="text-sm font-bold text-navy-700 dark:text-white">
                          {cell.value}
                        </p>
                      );
                    } else if (cell.column.Header === "PublicID") {
                      data = (
                        <p className="text-sm font-bold text-navy-700 dark:text-white">
                          {cell.value}
                        </p>
                      );
                    } else if (cell.column.Header === "Service") {
                      data = (
                        <p className="text-sm font-bold text-navy-700 dark:text-white">
                          {cell.value}
                        </p>
                      );
                    }else if (cell.column.Header === "LinkedObject") {
                      data = (
                        <p className="text-sm font-bold text-navy-700 dark:text-white">
                          {cell.value}
                        </p>
                      );
                    }  else if (cell.column.Header === "Type") {
                      data = (
                        <p className="text-sm font-bold text-navy-700 dark:text-white">
                          {cell.value==null ? "null": (cell.value ? "Inboud" : "Outbound")}
                        </p>
                      );
                    }else if (cell.column.Header === "Status") {
                      switch(cell.value){
                          case 'Generated':
                            data= <p className="text-sm font-bold text-navy-700" style={{color: "#4318FF"}}>
                            {cell.value}
                          </p>;
                            break;
                          case 'Delivered':
                            data= <p className="text-sm font-bold text-navy-700" style={{color: "#6AD2FF"}}>
                            {cell.value}
                          </p>;
                            break;
                          case 'Archived':
                            data= <p className="text-sm font-bold text-navy-700" style={{color: "#FFAA1D"}}>
                            {cell.value}
                          </p>;
                            break;
                          default:
                            data= <p className="text-sm font-bold text-navy-700" style={{color: "#cc1c08"}}>
                            {cell.value}
                          </p>;
                        }
                      }
                    return (
                      <td
                        className="pt-[14px] pb-[18px] sm:text-[14px]"
                        {...cell.getCellProps()}
                        key={index}
                      >
                        {data}
                      </td>
                    );
                  })}
                </tr>
              );
            })}
          </tbody>
        </table>
      </div>
    </Card>
  );
};

export default ComplexTable;
