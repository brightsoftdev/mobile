//
//  BasicProfileViewController.m
//  Nellodee
//
//  Created by Ada Hopper on 27/07/11.
//  Copyright 2011 __MyCompanyName__. All rights reserved.
//

#import "BasicProfileViewController.h"
#import "MeService.h"
#import "BasicInfo.h"
#import "NellodeeApp.h"
#import "TagsViewController.h"
#import "RolTableViewController.h"

@implementation BasicProfileViewController

@synthesize tableHeaderView;
@synthesize firstName, lastName, prefName,email;
@synthesize rol, departament, college;
@synthesize tags;


#define ROL 0
#define ACADEMIC 1
#define TAGS 2


/*- (id) init{
    self=[super init];

    return self;

}




- (id)initWithNibName:(NSString *)nibNameOrNil bundle:(NSBundle *)nibBundleOrNil
{
    self = [super initWithNibName:nibNameOrNil bundle:nibBundleOrNil];
    return self;
}

- (void)dealloc {
    [super dealloc];
}

- (void)didReceiveMemoryWarning
{
    // Releases the view if it doesn't have a superview.
    [super didReceiveMemoryWarning];
    
    // Release any cached data, images, etc that aren't in use.
}

#pragma mark - View lifecycle

- (void)viewDidLoad
{
    [super viewDidLoad];
    BasicInfo * basic = [[NellodeeApp sharedNellodeeData] basicInfo] ;    
    [firstName setText:[basic firstName]];
    [lastName setText:[basic lastName]];
    [prefName setText:[basic prefName]];
    [email setText:[basic email]];
    [rol setText:[basic rol]];
    [departament setText:[basic departament]];
    [college setText:[basic college]];
   
}

- (void)viewDidUnload
{
    [super viewDidUnload];
    // Release any retained subviews of the main view.
    // e.g. self.myOutlet = nil;
}

- (BOOL)shouldAutorotateToInterfaceOrientation:(UIInterfaceOrientation)interfaceOrientation
{
    // Return YES for supported orientations
    return (interfaceOrientation == UIInterfaceOrientationPortrait);
}

*/


#pragma mark -
#pragma mark View lifecycle


- (void)viewWillAppear:(BOOL)animated {

    // Update the view with current data before it is displayed.
    [super viewWillAppear:animated];
    
    // Scroll the table view to the top before it appears
    [self.tableView reloadData];
    [self.tableView setContentOffset:CGPointZero animated:YES];
    self.title = @"Profile";
}


#pragma mark -
#pragma mark Table view data source

- (NSInteger)numberOfSectionsInTableView:(UITableView *)tableView {
    // There are three sections, for rol, college info, and tags, in that order.
    return 3;
}


- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section {
    
    NSInteger rows = 0;
    switch (section) {
        case ROL:
            rows = 1;
            break;
        case ACADEMIC:
            rows = 2;
            break;
        case TAGS:
            rows = 1;
            break;
        default:
            break;
    }
    return rows;

}


- (NSString *)tableView:(UITableView *)tableView titleForHeaderInSection:(NSInteger)section {
    NSString *title = nil;
    // Return a title or nil as appropriate for the section.
    switch (section) {
        case ROL:
            title = @"Rol";
            break;
        case ACADEMIC:
            title = @"Academic Information";
            break;
        case TAGS:
            title = @"More Information";
            break;    
        default:
            break;
    }
    return title;;
}



- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath {
    
    
	static NSString *CellIdentifier = @"CellIdentifier";
    
    UITableViewCell *cell = [tableView dequeueReusableCellWithIdentifier:CellIdentifier];
    if (cell == nil) {
        cell = [[[UITableViewCell alloc] initWithStyle:UITableViewCellStyleDefault reuseIdentifier:CellIdentifier] autorelease];
    }
    
    
    switch (indexPath.section) {
        case ROL: 
            cell.textLabel.text =@"Celda 0";
            cell.accessoryType = UITableViewCellAccessoryDisclosureIndicator;
            cell.editingAccessoryType = UITableViewCellAccessoryNone;
            break;
        case ACADEMIC: // instructions
            cell.textLabel.text =@"Celda 1";
            break;
        case TAGS:
            cell.textLabel.text =@"Tags";
            cell.accessoryType = UITableViewCellAccessoryDisclosureIndicator;
            cell.editingAccessoryType = UITableViewCellAccessoryNone;
            break;
        default:
            break;
    }
        return cell;


}

- (void)tableView:(UITableView *)tableView didSelectRowAtIndexPath:(NSIndexPath *)indexPath {
    
    NSInteger section = indexPath.section;
    UIViewController *nextViewController = nil;
    
    /*
     What to do on selection depends on what section the row is in.
     For Type, Instructions, and Ingredients, create and push a new view controller of the type appropriate for the next screen.
     */
    switch (section) {
        case ROL:
            nextViewController = [[RolTableViewController alloc] initWithStyle:UITableViewStyleGrouped];
            //((TypeSelectionViewController *)nextViewController).recipe = recipe;
            break;
			
        case TAGS:
            nextViewController = [[TagsViewController alloc] initWithNibName:@"TagsViewController" bundle:nil];
            break;
			
        case ACADEMIC:
            /*nextViewController = [[IngredientDetailViewController alloc] initWithStyle:UITableViewStyleGrouped];
            ((IngredientDetailViewController *)nextViewController).recipe = recipe;
            
            if (indexPath.row < [recipe.ingredients count]) {
                Ingredient *ingredient = [ingredients objectAtIndex:indexPath.row];
                ((IngredientDetailViewController *)nextViewController).ingredient = ingredient;
            }*/
            break;
			
        default:
            break;
    }
    
    // If we got a new view controller, push it .
    if (nextViewController) {
        [self.navigationController pushViewController:nextViewController animated:YES];
        [nextViewController release];
    }
}





@end
