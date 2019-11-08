// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { browser, ExpectedConditions as ec, promise } from 'protractor';
import { NavBarPage, SignInPage } from '../../page-objects/jhi-page-objects';

// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { ProductTagsComponentsPage, ProductTagsDeleteDialog, ProductTagsUpdatePage } from './product-tags.page-object';

const expect = chai.expect;

describe('ProductTags e2e test', () => {
  let navBarPage: NavBarPage;
  let signInPage: SignInPage;
  let productTagsComponentsPage: ProductTagsComponentsPage;
  let productTagsUpdatePage: ProductTagsUpdatePage;
  let productTagsDeleteDialog: ProductTagsDeleteDialog;

  before(async () => {
    await browser.get('/');
    navBarPage = new NavBarPage();
    signInPage = await navBarPage.getSignInPage();
    await signInPage.autoSignInUsing('admin', 'admin');
    await browser.wait(ec.visibilityOf(navBarPage.entityMenu), 5000);
  });

  it('should load ProductTags', async () => {
    await navBarPage.goToEntity('product-tags');
    productTagsComponentsPage = new ProductTagsComponentsPage();
    await browser.wait(ec.visibilityOf(productTagsComponentsPage.title), 5000);
    expect(await productTagsComponentsPage.getTitle()).to.eq('epmresourcesApp.productTags.home.title');
  });

  it('should load create ProductTags page', async () => {
    await productTagsComponentsPage.clickOnCreateButton();
    productTagsUpdatePage = new ProductTagsUpdatePage();
    expect(await productTagsUpdatePage.getPageTitle()).to.eq('epmresourcesApp.productTags.home.createOrEditLabel');
    await productTagsUpdatePage.cancel();
  });

  it('should create and save ProductTags', async () => {
    const nbButtonsBeforeCreate = await productTagsComponentsPage.countDeleteButtons();

    await productTagsComponentsPage.clickOnCreateButton();
    await promise.all([productTagsUpdatePage.setTagNameInput('tagName'), productTagsUpdatePage.productSelectLastOption()]);
    expect(await productTagsUpdatePage.getTagNameInput()).to.eq('tagName', 'Expected TagName value to be equals to tagName');
    await productTagsUpdatePage.save();
    expect(await productTagsUpdatePage.getSaveButton().isPresent(), 'Expected save button disappear').to.be.false;

    expect(await productTagsComponentsPage.countDeleteButtons()).to.eq(nbButtonsBeforeCreate + 1, 'Expected one more entry in the table');
  });

  it('should delete last ProductTags', async () => {
    const nbButtonsBeforeDelete = await productTagsComponentsPage.countDeleteButtons();
    await productTagsComponentsPage.clickOnLastDeleteButton();

    productTagsDeleteDialog = new ProductTagsDeleteDialog();
    expect(await productTagsDeleteDialog.getDialogTitle()).to.eq('epmresourcesApp.productTags.delete.question');
    await productTagsDeleteDialog.clickOnConfirmButton();

    expect(await productTagsComponentsPage.countDeleteButtons()).to.eq(nbButtonsBeforeDelete - 1);
  });

  after(async () => {
    await navBarPage.autoSignOut();
  });
});
