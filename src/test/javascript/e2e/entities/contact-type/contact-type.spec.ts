// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { browser, ExpectedConditions as ec, promise } from 'protractor';
import { NavBarPage, SignInPage } from '../../page-objects/jhi-page-objects';

// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { ContactTypeComponentsPage, ContactTypeDeleteDialog, ContactTypeUpdatePage } from './contact-type.page-object';

const expect = chai.expect;

describe('ContactType e2e test', () => {
  let navBarPage: NavBarPage;
  let signInPage: SignInPage;
  let contactTypeComponentsPage: ContactTypeComponentsPage;
  let contactTypeUpdatePage: ContactTypeUpdatePage;
  let contactTypeDeleteDialog: ContactTypeDeleteDialog;

  before(async () => {
    await browser.get('/');
    navBarPage = new NavBarPage();
    signInPage = await navBarPage.getSignInPage();
    await signInPage.autoSignInUsing('admin', 'admin');
    await browser.wait(ec.visibilityOf(navBarPage.entityMenu), 5000);
  });

  it('should load ContactTypes', async () => {
    await navBarPage.goToEntity('contact-type');
    contactTypeComponentsPage = new ContactTypeComponentsPage();
    await browser.wait(ec.visibilityOf(contactTypeComponentsPage.title), 5000);
    expect(await contactTypeComponentsPage.getTitle()).to.eq('epmresourcesApp.contactType.home.title');
  });

  it('should load create ContactType page', async () => {
    await contactTypeComponentsPage.clickOnCreateButton();
    contactTypeUpdatePage = new ContactTypeUpdatePage();
    expect(await contactTypeUpdatePage.getPageTitle()).to.eq('epmresourcesApp.contactType.home.createOrEditLabel');
    await contactTypeUpdatePage.cancel();
  });

  it('should create and save ContactTypes', async () => {
    const nbButtonsBeforeCreate = await contactTypeComponentsPage.countDeleteButtons();

    await contactTypeComponentsPage.clickOnCreateButton();
    await promise.all([contactTypeUpdatePage.setContactTypeNameInput('contactTypeName')]);
    expect(await contactTypeUpdatePage.getContactTypeNameInput()).to.eq(
      'contactTypeName',
      'Expected ContactTypeName value to be equals to contactTypeName'
    );
    await contactTypeUpdatePage.save();
    expect(await contactTypeUpdatePage.getSaveButton().isPresent(), 'Expected save button disappear').to.be.false;

    expect(await contactTypeComponentsPage.countDeleteButtons()).to.eq(nbButtonsBeforeCreate + 1, 'Expected one more entry in the table');
  });

  it('should delete last ContactType', async () => {
    const nbButtonsBeforeDelete = await contactTypeComponentsPage.countDeleteButtons();
    await contactTypeComponentsPage.clickOnLastDeleteButton();

    contactTypeDeleteDialog = new ContactTypeDeleteDialog();
    expect(await contactTypeDeleteDialog.getDialogTitle()).to.eq('epmresourcesApp.contactType.delete.question');
    await contactTypeDeleteDialog.clickOnConfirmButton();

    expect(await contactTypeComponentsPage.countDeleteButtons()).to.eq(nbButtonsBeforeDelete - 1);
  });

  after(async () => {
    await navBarPage.autoSignOut();
  });
});
