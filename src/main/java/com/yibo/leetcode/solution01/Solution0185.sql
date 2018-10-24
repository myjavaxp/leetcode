Select d.Name as Department, e.Name as Employee, e.Salary
from Department d,
     Employee e
where e.DepartmentId = d.Id
  and (Select count(distinct Salary) From Employee where DepartmentId = d.Id
                                                     and Salary > e.Salary) < 3
order by Department;

SELECT D1.Name Department, E1.Name Employee, E1.Salary
FROM Employee E1,
     Employee E2,
     Department D1
WHERE E1.DepartmentID = E2.DepartmentID
  AND E2.Salary >= E1.Salary
  AND E1.DepartmentID = D1.ID
GROUP BY E1.Name
HAVING COUNT(DISTINCT E2.Salary) <= 3
ORDER BY D1.Name, E1.Salary DESC;