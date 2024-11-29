package hibernate;

import org.hibernate.Session;

import java.time.LocalDateTime;
import java.util.Arrays;

public class Main {

    public static void saveTestResult(Session session, String testName, String status, String details) {
        TestResult testResult = new TestResult();
        testResult.setTestName(testName);
        testResult.setStatus(status);
        testResult.setDetails(details);
        testResult.setExecutionTime(LocalDateTime.now());

        session.beginTransaction();
        session.save(testResult);
        session.getTransaction().commit();
        System.out.println("test result saved: " + testResult);
    }

    public static void main(String[] args) {
        Session session = HybernateManager.getSessionFactory().openSession();

        try {
            //test data
            Data data = new Data();
            data.setName("myname");
            data.setAge(15);

            Address add1 = new Address();
            add1.setCity("Lviv");
            add1.setState("Lvivska");
            add1.setZip("700000");
            add1.setData(data);
            data.setAddress(Arrays.asList(add1));

            Course course1 = new Course();
            course1.setCourseName("AQA");
            data.setCourses(Arrays.asList(course1));

            //create
            session.beginTransaction();
            Long id = (Long) session.save(data);
            session.getTransaction().commit();
            saveTestResult(session, "Create Data Test", "SUCCESS", "Data created with ID " + id);

            //read
            Data readData = session.get(Data.class, id);
            if (readData != null) {
                System.out.println(readData);
                saveTestResult(session, "Read Data Test", "SUCCESS", "Data read successfully with ID " + id);
            } else {
                saveTestResult(session, "Read Data Test", "FAILURE", "Data not found with ID " + id);
            }

            //update
            session.beginTransaction();
            data.setAge(20);
            add1.setCity("Kyiv");
            add1.setState("Kyivska");
            session.update(data);
            session.getTransaction().commit();
            saveTestResult(session, "Update Data Test", "SUCCESS", "Data updated");

            //delete
            session.beginTransaction();
            session.delete(data);
            session.getTransaction().commit();
            Data deletedData = session.get(Data.class, id);
            if (deletedData == null) {
                saveTestResult(session, "delete data test", "success", "data deleted with ID " + id);
            } else {
                saveTestResult(session, "delete data test", "fail", "failed to delete data with ID " + id);
            }

        } catch (Exception e) {
            saveTestResult(session, "general test execution", "fail", "error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            session.close();
            HybernateManager.shutdown();
        }
    }
}
