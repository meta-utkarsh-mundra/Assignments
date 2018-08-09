import java.util.ArrayList;

import java.util.List;

import employee.*;

public class EmployeeCollectionDuplicateHandling {

	List<Employee> setOfEmployee = new ArrayList<Employee>();
	
/**
*Add Employee in the setOfEmployee List
*@param employee
*/
	public boolean addEmployee(Employee employee) {
		boolean isEqualFlag = true;
		for (Employee e : setOfEmployee) {
			if (e.equals(employee)) {
				isEqualFlag = false;
			}
		}
		return isEqualFlag ? setOfEmployee.add(employee) : isEqualFlag;
	}

}