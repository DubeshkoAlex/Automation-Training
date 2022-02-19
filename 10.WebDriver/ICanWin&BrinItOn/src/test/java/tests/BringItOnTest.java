package tests;

import org.testng.annotations.Test;

import static constants.Constants.TextVariables.CODE_2;
import static constants.Constants.TextVariables.PASTE_NAME_TITLE_2;
import static constants.Constants.Url.PASTEBIN_URL;

public class BringItOnTest extends BaseTest{
    @Test
    public static void bringItOn(){

        basePage.open(PASTEBIN_URL);
        page
                .pasteInCodeInput(CODE_2)
                .scrollToOptionalPastTitle()
                .clickOnSyntaxHighlightingListBox()
                .clickOnSyntaxHighlightingListBoxElement()
                .clickOnPasteExpirationListBox()
                .clickOnPasteExpirationListBoxElement()
                .pasteInPasteNameTitleInput(PASTE_NAME_TITLE_2)
                .clickOnCreateNewPasteButton()
        ;
        newPastePage
                .checkHeaderShouldBeLikePasteNameTitle()
                .checkSyntaxShouldBeBash()
                .checkCodeShouldBeLikeInSecondPoint()
        ;
    }
}
