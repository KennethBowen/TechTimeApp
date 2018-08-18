package com.techtimeapp.techtime.view.view.data;

import java.util.List;

public interface RepairOrderInterface {
    List<RepairOrder> getRepairOrder();
    RepairOrder createNewRepairOrder();

    void deleteRepairOrder(RepairOrder repairOrder);


    void insertRepairOrder(RepairOrder repairOrder);
}
