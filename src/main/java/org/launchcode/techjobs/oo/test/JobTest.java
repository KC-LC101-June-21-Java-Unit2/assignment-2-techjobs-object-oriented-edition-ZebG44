package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1, job2);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(job3 instanceof Job);
        //assertTrue(job3.getName() instanceof String);
        assertTrue(job3.getEmployer() instanceof JobField);
        assertTrue(job3.getLocation() instanceof JobField);
        assertTrue(job3.getPositionType() instanceof JobField);
        assertTrue(job3.getCoreCompetency() instanceof JobField);
        assertEquals("Product tester", job3.getName());
        assertEquals("ACME", job3.getEmployer().getValue());
        assertEquals("Desert", job3.getLocation().getValue());
        assertEquals("Quality control", job3.getPositionType().getValue());
        assertEquals("Persistence", job3.getCoreCompetency().getValue());
    }
//String aName, Employer aEmployer, Location aLocation, PositionType aPositionType, CoreCompetency aCoreCompetency
    @Test
    public void testJobsForEquality() {
        Job job4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job5 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(job4.equals(job5));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job job6 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        int lastIndex = (job6.toString().length() - 1);

        assertEquals(job6.toString().charAt(0), '\n');
        assertEquals(job6.toString().charAt(lastIndex), '\n');
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job7 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String[] lines = job7.toString().trim().split("\n");

        assertEquals("ID:", lines[0]);
        assertEquals("Name:", lines[1]);
        assertEquals("Employer:", lines[2]);
        assertEquals("Location:", lines[3]);
        assertEquals("Position Type:", lines[4]);
        assertEquals("Core Competency:", lines[5]);

        assertEquals("Product tester", lines[1].endsWith(job7.getName()));
        //assertEquals( lines[0].endsWith(Integer.toString(job7.getId())));
        assertEquals("ACME", lines[2].endsWith(job7.getEmployer().toString()));
        assertEquals("Desert", lines[3].endsWith(job7.getLocation().toString()));
        assertEquals("Quality control", lines[4].endsWith(job7.getPositionType().toString()));
        assertEquals("Persistence", lines[5].endsWith(job7.getCoreCompetency().toString()));
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job job8 = new Job();
        String[] lines = job8.toString().trim().split("\n");

        System.out.println(job8.toString());

        List<String> list = new ArrayList<String>(Arrays.asList(lines));
        list.remove(0);
        lines = list.toArray(new String[0]);

        String empty = "Data not available";

        for (String line : lines) {
            assertEquals("Data not available", empty);
        }
    }


}
