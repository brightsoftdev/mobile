//
//  CategoriesViewController.m
//  Nellodee
//
//  Created by Ada Hopper on 11/08/11.
//  Copyright 2011 __MyCompanyName__. All rights reserved.
//

#import "CategoriesViewController.h"
#import "NellodeeApp.h"
#import "CategoriesDataController.h"

@implementation CategoriesViewController
@synthesize categories,catString;

#pragma mark -
#pragma mark View lifecycle

- (id)initWithStyle:(UITableViewStyle)style
{
    self = [super initWithStyle:style];
    if (self) {
        [[NSNotificationCenter defaultCenter] addObserver:self
                                                 selector:@selector(loadCategoriesView:) 
                                                     name:@"meServiceNotification"
                                                   object:nil];    
    }
    return self;
}
- (void) loadCategoriesView:(NSNotification *) notification{
    
    
    if ([[notification name] isEqualToString:@"meServiceNotification"]){
        NSLog (@"[CATEGORIES] Successfully received the notification!");
        
        
        self.navigationItem.rightBarButtonItem = self.editButtonItem;
        
        //Get user information
		categories = [NSMutableArray arrayWithArray:[[[NellodeeApp sharedNellodeeData] userProfile] categories]];
		self.catString = [NSMutableArray array];
		CategoriesDataController *catData = [[CategoriesDataController alloc] init];
		for (int i = 0; i < [categories count]; i = i + 1){
			[catString addObject:[catData categoriesShoWithTag:[categories objectAtIndex:i]]];
		}
		
		[catData release];
		
        // Update the view with current data before it is displayed.
        [super viewWillAppear:YES];
        
        // Scroll the table view to the top before it appears  
        [self.tableView setContentOffset:CGPointZero animated:YES];
        self.title = @"Categories";
        
        [self.tableView reloadData]; 
        
    }
}




#pragma mark -
#pragma mark Table view data source

- (NSInteger)numberOfSectionsInTableView:(UITableView *)tableView {
    // Return the number of sections.
    return 1;
}


- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section {
    // Return the number of rows in the section.
	categories = [NSMutableArray arrayWithArray:[[[NellodeeApp sharedNellodeeData] userProfile] categories]];
    return [categories count];
}


// Customize the appearance of table view cells.
- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath {
    
    static NSString *CellIdentifier = @"Cell";
    
    UITableViewCell *cell = [tableView dequeueReusableCellWithIdentifier:CellIdentifier];
    if (cell == nil) {
        cell = [[[UITableViewCell alloc] initWithStyle:UITableViewCellStyleDefault reuseIdentifier:CellIdentifier] autorelease];
    }
    
	//NSLog(@" indice: %@", indexPath.row);
	cell.textLabel.text = [self.catString objectAtIndex:indexPath.row];
	[[cell textLabel] setFont:[UIFont systemFontOfSize:10.0]];
    return cell;
}


/*
// Override to support conditional editing of the table view.
- (BOOL)tableView:(UITableView *)tableView canEditRowAtIndexPath:(NSIndexPath *)indexPath {
    // Return NO if you do not want the specified item to be editable.
    return YES;
}
*/


/*
// Override to support editing the table view.
- (void)tableView:(UITableView *)tableView commitEditingStyle:(UITableViewCellEditingStyle)editingStyle forRowAtIndexPath:(NSIndexPath *)indexPath {
    
    if (editingStyle == UITableViewCellEditingStyleDelete) {
        // Delete the row from the data source.
        [tableView deleteRowsAtIndexPaths:[NSArray arrayWithObject:indexPath] withRowAnimation:UITableViewRowAnimationFade];
    }   
    else if (editingStyle == UITableViewCellEditingStyleInsert) {
        // Create a new instance of the appropriate class, insert it into the array, and add a new row to the table view.
    }   
}
*/


/*
// Override to support rearranging the table view.
- (void)tableView:(UITableView *)tableView moveRowAtIndexPath:(NSIndexPath *)fromIndexPath toIndexPath:(NSIndexPath *)toIndexPath {
}
*/


/*
// Override to support conditional rearranging of the table view.
- (BOOL)tableView:(UITableView *)tableView canMoveRowAtIndexPath:(NSIndexPath *)indexPath {
    // Return NO if you do not want the item to be re-orderable.
    return YES;
}
*/


#pragma mark -
#pragma mark Table view delegate

- (void)tableView:(UITableView *)tableView didSelectRowAtIndexPath:(NSIndexPath *)indexPath {
    // Navigation logic may go here. Create and push another view controller.
    /*
    <#DetailViewController#> *detailViewController = [[<#DetailViewController#> alloc] initWithNibName:@"<#Nib name#>" bundle:nil];
    // ...
    // Pass the selected object to the new view controller.
    [self.navigationController pushViewController:detailViewController animated:YES];
    [detailViewController release];
    */
}


#pragma mark -
#pragma mark Memory management

- (void)didReceiveMemoryWarning {
    // Releases the view if it doesn't have a superview.
    [super didReceiveMemoryWarning];
    
    // Relinquish ownership any cached data, images, etc. that aren't in use.
}

- (void)viewDidUnload {
    // Relinquish ownership of anything that can be recreated in viewDidLoad or on demand.
    // For example: self.myOutlet = nil;
}


- (void)dealloc {
	[categories release];
	[catString release];
    [super dealloc];
}


@end

