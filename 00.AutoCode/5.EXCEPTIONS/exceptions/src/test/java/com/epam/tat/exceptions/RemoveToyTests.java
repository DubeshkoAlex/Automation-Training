package com.epam.tat.exceptions;

import com.epam.tat.exceptions.bean.Toy;
import com.epam.tat.exceptions.constants.GameType;
import com.epam.tat.exceptions.constants.Gender;
import com.epam.tat.exceptions.constants.Material;
import com.epam.tat.exceptions.constants.Size;
import com.epam.tat.exceptions.exception.RemoveToyException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RemoveToyTests extends AbstractBaseTests {

    @Test
    void shouldRemoveToy() {
        Toy toy = new Toy(5L, "Toy kitchen", GameType.STORY, Gender.FEMALE, 7, Size.LARGE, Material.PLASTIC, 1170);

        Assertions.assertAll("Toy removed successfully!",
                () -> Assertions.assertTrue(playroom.removeToy(toy), "Check return value"),
                () -> Assertions.assertFalse(playroom.getAllToys().contains(toy), "Check that list is not contained removed toy!"));
    }

    @Test
    void shouldThrowExceptionForRemoveToyMethodWhenNullValue() {
        Assertions.assertThrows(RemoveToyException.class, () -> playroom.removeToy(null));
    }
}
