// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { browser, ExpectedConditions as ec, promise } from 'protractor';
import { NavBarPage, SignInPage } from '../../page-objects/jhi-page-objects';

// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { AddressesComponentsPage, AddressesDeleteDialog, AddressesUpdatePage } from './addresses.page-object';

const expect = chai.expect;

describe('Addresses e2e test', () => {
  let navBarPage: NavBarPage;
  let signInPage: SignInPage;
  let addressesComponentsPage: AddressesComponentsPage;
  let addressesUpdatePage: AddressesUpdatePage;
  let addressesDeleteDialog: AddressesDeleteDialog;

  before(async () => {
    await browser.get('/');
    navBarPage = new NavBarPage();
    signInPage = await navBarPage.getSignInPage();
    await signInPage.autoSignInUsing('admin', 'admin');
    await browser.wait(ec.visibilityOf(navBarPage.entityMenu), 5000);
  });

  it('should load Addresses', async () => {
    await navBarPage.goToEntity('addresses');
    addressesComponentsPage = new AddressesComponentsPage();
    await browser.wait(ec.visibilityOf(addressesComponentsPage.title), 5000);
    expect(await addressesComponentsPage.getTitle()).to.eq('epmresourcesApp.addresses.home.title');
  });

  it('should load create Addresses page', async () => {
    await addressesComponentsPage.clickOnCreateButton();
    addressesUpdatePage = new AddressesUpdatePage();
    expect(await addressesUpdatePage.getPageTitle()).to.eq('epmresourcesApp.addresses.home.createOrEditLabel');
    await addressesUpdatePage.cancel();
  });

  it('should create and save Addresses', async () => {
    const nbButtonsBeforeCreate = await addressesComponentsPage.countDeleteButtons();

    await addressesComponentsPage.clickOnCreateButton();
    await promise.all([
      addressesUpdatePage.setContactPersonInput('contactPerson'),
      addressesUpdatePage.setContactNumberInput('contactNumber'),
      addressesUpdatePage.setContactEmailAddressInput('contactEmailAddress'),
      addressesUpdatePage.setAddressLine1Input('addressLine1'),
      addressesUpdatePage.setAddressLine2Input('addressLine2'),
      addressesUpdatePage.setCityInput('city'),
      addressesUpdatePage.setPostalCodeInput('postalCode'),
      addressesUpdatePage.stateProvinceSelectLastOption(),
      addressesUpdatePage.addressTypeSelectLastOption(),
      addressesUpdatePage.personSelectLastOption()
    ]);
    expect(await addressesUpdatePage.getContactPersonInput()).to.eq(
      'contactPerson',
      'Expected ContactPerson value to be equals to contactPerson'
    );
    expect(await addressesUpdatePage.getContactNumberInput()).to.eq(
      'contactNumber',
      'Expected ContactNumber value to be equals to contactNumber'
    );
    expect(await addressesUpdatePage.getContactEmailAddressInput()).to.eq(
      'contactEmailAddress',
      'Expected ContactEmailAddress value to be equals to contactEmailAddress'
    );
    expect(await addressesUpdatePage.getAddressLine1Input()).to.eq(
      'addressLine1',
      'Expected AddressLine1 value to be equals to addressLine1'
    );
    expect(await addressesUpdatePage.getAddressLine2Input()).to.eq(
      'addressLine2',
      'Expected AddressLine2 value to be equals to addressLine2'
    );
    expect(await addressesUpdatePage.getCityInput()).to.eq('city', 'Expected City value to be equals to city');
    expect(await addressesUpdatePage.getPostalCodeInput()).to.eq('postalCode', 'Expected PostalCode value to be equals to postalCode');
    const selectedDefaultInd = addressesUpdatePage.getDefaultIndInput();
    if (await selectedDefaultInd.isSelected()) {
      await addressesUpdatePage.getDefaultIndInput().click();
      expect(await addressesUpdatePage.getDefaultIndInput().isSelected(), 'Expected defaultInd not to be selected').to.be.false;
    } else {
      await addressesUpdatePage.getDefaultIndInput().click();
      expect(await addressesUpdatePage.getDefaultIndInput().isSelected(), 'Expected defaultInd to be selected').to.be.true;
    }
    const selectedActiveInd = addressesUpdatePage.getActiveIndInput();
    if (await selectedActiveInd.isSelected()) {
      await addressesUpdatePage.getActiveIndInput().click();
      expect(await addressesUpdatePage.getActiveIndInput().isSelected(), 'Expected activeInd not to be selected').to.be.false;
    } else {
      await addressesUpdatePage.getActiveIndInput().click();
      expect(await addressesUpdatePage.getActiveIndInput().isSelected(), 'Expected activeInd to be selected').to.be.true;
    }
    await addressesUpdatePage.save();
    expect(await addressesUpdatePage.getSaveButton().isPresent(), 'Expected save button disappear').to.be.false;

    expect(await addressesComponentsPage.countDeleteButtons()).to.eq(nbButtonsBeforeCreate + 1, 'Expected one more entry in the table');
  });

  it('should delete last Addresses', async () => {
    const nbButtonsBeforeDelete = await addressesComponentsPage.countDeleteButtons();
    await addressesComponentsPage.clickOnLastDeleteButton();

    addressesDeleteDialog = new AddressesDeleteDialog();
    expect(await addressesDeleteDialog.getDialogTitle()).to.eq('epmresourcesApp.addresses.delete.question');
    await addressesDeleteDialog.clickOnConfirmButton();

    expect(await addressesComponentsPage.countDeleteButtons()).to.eq(nbButtonsBeforeDelete - 1);
  });

  after(async () => {
    await navBarPage.autoSignOut();
  });
});
