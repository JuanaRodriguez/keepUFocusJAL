package Test.Model.Application;

import Model.Applications.ActivityType;
import Model.Applications.ActivityTypeHandler;
import org.junit.Assert;
import org.junit.Test;

/**
 * @autor: JuanaRodriguez
 */
public class ActivityTypeTest {
    @Test
    public void VerifyThatANewActivityTypeWasAdd() {
        ActivityType activityType = new ActivityType();
        activityType.setActivityTypeName("Other");
        activityType.save();
        Assert.assertEquals(activityType.getActivityTypeName(), ActivityTypeHandler.getActivityTypeById(activityType.getActivityTypeId()).getActivityTypeName());
        activityType.delete();
    }

    @Test
    public void VerifyThatAnActivityWasUpdated() {
        ActivityType activityType = new ActivityType();
        activityType.setActivityTypeName("Lunch");
        activityType.save();
        ActivityType otherActivityType = ActivityTypeHandler.getActivityTypeById(activityType.getActivityTypeId());
        otherActivityType.setActivityTypeName("Lunch");
        otherActivityType.update();
        Assert.assertEquals(otherActivityType.getActivityTypeName(), ActivityTypeHandler.getActivityTypeById(activityType.getActivityTypeId()).getActivityTypeName());
        activityType.delete();
    }

    @Test
    public void VerifyThatAnActivityWasDeleted() {
        ActivityType activityType = new ActivityType();
        activityType.setActivityTypeName("Breaks");
        activityType.save();
        activityType.delete();
        Assert.assertNull(ActivityTypeHandler.getActivityTypeById(activityType.getActivityTypeId()));
    }
}
