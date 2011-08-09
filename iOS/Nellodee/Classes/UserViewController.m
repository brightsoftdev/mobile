//
//  UserViewController.m
//  Nellodee
//
//  Created by Ada Hopper on 24/07/11.
//  Copyright 2011 __MyCompanyName__. All rights reserved.
//

#import "UserViewController.h"
#import "ProfileViewController.h"
#import "TagsViewController.h"


@implementation UserViewController

@synthesize options,profileNavController;

#define MESSAGES 0
#define PROFILE 1
#define LIB 2
#define MEMBER 3
#define CONTACTS 4

+ (NSArray *) defaultOptions{
    return [NSArray arrayWithObjects:@"My messages", @"My profile", @"My library", @"My membership", @"My contacts",nil];
}

-(id) init{
    self = [super initWithStyle:UITableViewStyleGrouped];
    if (self != nil){
        self->options = [[[self class] defaultOptions] mutableCopy];
        assert(self->options !=nil);
    
        self.title=@"Sakai OAE";
        /*self.navigationItem.rightBarButtonItem = [[[UIBarButtonItem alloc] 
                                                   initWithTitle:@"Opciones" 
                                                   style:UIBarButtonItemStyleBordered 
                                                   target:self 
                                                   action:@selector(optionsAction:)] autorelease];*/
    }
    return self;

}

- (void)loadView
{
    UITableView *tableView = [[UITableView alloc] initWithFrame:[[UIScreen mainScreen] applicationFrame]
                                                          style:UITableViewStyleGrouped];
    tableView.autoresizingMask = UIViewAutoresizingFlexibleHeight|UIViewAutoresizingFlexibleWidth;
    tableView.delegate = self;
    tableView.dataSource = self;
    [tableView reloadData];
    
    self.view = tableView;
    [tableView release];
}


- (id)initWithStyle:(UITableViewStyle)style
{
    self = [super initWithStyle:style];
    if (self) {
        // Custom initialization
    }
    return self;
}

- (void)dealloc
{
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

    // Uncomment the following line to preserve selection between presentations.
    // self.clearsSelectionOnViewWillAppear = NO;
 
    // Uncomment the following line to display an Edit button in the navigation bar for this view controller.
    // self.navigationItem.rightBarButtonItem = self.editButtonItem;
}

- (void)viewDidUnload
{
    [super viewDidUnload];
    // Release any retained subviews of the main view.
    // e.g. self.myOutlet = nil;
}

- (void)viewWillAppear:(BOOL)animated
{
    [super viewWillAppear:animated];
}

- (void)viewDidAppear:(BOOL)animated
{
    [super viewDidAppear:animated];
}

- (void)viewWillDisappear:(BOOL)animated
{
    [super viewWillDisappear:animated];
}

- (void)viewDidDisappear:(BOOL)animated
{
    [super viewDidDisappear:animated];
}

- (BOOL)shouldAutorotateToInterfaceOrientation:(UIInterfaceOrientation)interfaceOrientation
{
    // Return YES for supported orientations
    return (interfaceOrientation == UIInterfaceOrientationPortrait);
}

#pragma mark - Table view data source

- (NSInteger)numberOfSectionsInTableView:(UITableView *)tableView
{
    // Return the number of sections.
    return 1;
}

- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section
{
    // Return the number of rows in the section.
    return [self.options count];
}

- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath
{
    static NSString *CellIdentifier = @"Cell";
    
    UITableViewCell *cell = [tableView dequeueReusableCellWithIdentifier:CellIdentifier];
    if (cell == nil) {
        cell = [[[UITableViewCell alloc] initWithStyle:UITableViewCellStyleValue1 reuseIdentifier:CellIdentifier] autorelease];
    }
    
    // Configure the cell...
    //NSInteger row =[indexPath row];
    //cell.text = [options objectAtIndex:row];
    cell.textLabel.text = [[self.options objectAtIndex:indexPath.row] description];

    
    return cell;
}

- (UITableViewCellAccessoryType)tableView:(UITableView *)tv accessoryTypeForRowWithIndexPath:(NSIndexPath *)indexPath{
    
    return UITableViewCellAccessoryDisclosureIndicator;
}

/*
// Override to support conditional editing of the table view.
- (BOOL)tableView:(UITableView *)tableView canEditRowAtIndexPath:(NSIndexPath *)indexPath
{
    // Return NO if you do not want the specified item to be editable.
    return YES;
}
*/

/*
// Override to support editing the table view.
- (void)tableView:(UITableView *)tableView commitEditingStyle:(UITableViewCellEditingStyle)editingStyle forRowAtIndexPath:(NSIndexPath *)indexPath
{
    if (editingStyle == UITableViewCellEditingStyleDelete) {
        // Delete the row from the data source
        [tableView deleteRowsAtIndexPaths:[NSArray arrayWithObject:indexPath] withRowAnimation:UITableViewRowAnimationFade];
    }   
    else if (editingStyle == UITableViewCellEditingStyleInsert) {
        // Create a new instance of the appropriate class, insert it into the array, and add a new row to the table view
    }   
}
*/

/*
// Override to support rearranging the table view.
- (void)tableView:(UITableView *)tableView moveRowAtIndexPath:(NSIndexPath *)fromIndexPath toIndexPath:(NSIndexPath *)toIndexPath
{
}
*/

/*
// Override to support conditional rearranging of the table view.
- (BOOL)tableView:(UITableView *)tableView canMoveRowAtIndexPath:(NSIndexPath *)indexPath
{
    // Return NO if you do not want the item to be re-orderable.
    return YES;
}
*/

#pragma mark - Table view delegate

- (void)tableView:(UITableView *)tableView didSelectRowAtIndexPath:(NSIndexPath *)indexPath{
	
	// When a row is selected, create the detail view controller and set its detail item to the item associated with the selected row.
    if([indexPath row] == MESSAGES){
    
        
        
    
    }
	else if([indexPath row] == PROFILE){
		ProfileViewController *profileViewController = [[ProfileViewController alloc] initWithStyle:UITableViewStyleGrouped];
		
		// Push the detail view controller.
		[[self navigationController] pushViewController:profileViewController animated:YES];
		[profileViewController release];
		
	}
	else if([indexPath row] == LIB){
	}
	else if([indexPath row] == MEMBER){
	}
    else{
        
        /*
         When a row is selected, create the detail view controller and set its detail item to the item associated with the selected row.
         */
        TagsViewController *profileViewController = [[TagsViewController alloc] init];
        
        // Push the detail view controller.
        [[self navigationController] pushViewController:profileViewController animated:YES];
        [profileViewController release];
        
    }

}

@end
