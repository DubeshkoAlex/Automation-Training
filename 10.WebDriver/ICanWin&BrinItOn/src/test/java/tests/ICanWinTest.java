package tests;

import org.testng.annotations.Test;

import static constants.Constants.TextVariables.*;
import static constants.Constants.Url.PASTEBIN_URL;

public class ICanWinTest extends BaseTest{

    @Test
    public static void iCanWin(){
        basePage.open(PASTEBIN_URL);
        page
                .pasteInCodeInput(CODE_1)
                .scrollToOptionalPastTitle()
                .clickOnPasteExpirationListBox()
                .clickOnPasteExpirationListBoxElement()
                .pasteInPasteNameTitleInput(PASTE_NAME_TITLE_1)
                .clickOnCreateNewPasteButton()
        ;
    }

}

