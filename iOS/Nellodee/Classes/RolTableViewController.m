//
//  RolTableViewController.m
//  Nellodee
//
//  Created by Ada Hopper on 02/08/11.
//  Copyright 2011 __MyCompanyName__. All rights reserved.
//

#import "RolTableViewController.h"


@implementation RolTableViewController

@synthesize rolTypes;


#pragma mark -
#pragma mark UIViewController

- (void)viewWillAppear:(BOOL)animated {
    [super viewWillAppear:animated];

    self.rolTypes =[[[NSArray alloc] 
                      initWithObjects:@"Academic related stuff",@"Academic stuff",@"Assistant stuff",@"Graduate Student", 
                                      @"Undergraduate Student", @"Non-Academic stuff",  @"Postgraduate Student", 
                                      @"Research Stuff", @"Other",nil] autorelease];
     

}


- (BOOL)shouldAutorotateToInterfaceOrientation:(UIInterfaceOrientation)interfaceOrientation {
    return (interfaceOrientation != UIInterfaceOrientationPortraitUpsideDown);
}


#pragma mark -
#pragma mark UITableView Delegate/Datasource

- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section {
    // Number of rows is the number of recipe types
    return [rolTypes count];
}


- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath {
    static NSString *MyIdentifier = @"MyIdentifier";
    
    UITableViewCell *cell = [tableView dequeueReusableCellWithIdentifier:MyIdentifier];
    if (cell == nil) {
        cell = [[[UITableViewCell alloc] initWithStyle:UITableViewCellStyleDefault reuseIdentifier:MyIdentifier] autorelease];
    }
    
    // Configure the cell
    cell.textLabel.text = [rolTypes objectAtIndex:indexPath.row];
    
    //TODO: I should compare with the studen rol
    if ([rolTypes objectAtIndex:indexPath.row] == @"Academic related stuff") {
        cell.accessoryType = UITableViewCellAccessoryCheckmark;
    }
    
    return cell;
}

//TODO
- (void)tableView:(UITableView *)tableView didSelectRowAtIndexPath:(NSIndexPath *)indexPath {
	
    // If there was a previous selection, unset the accessory view for its cell.
	/*NSManagedObject *currentType = recipe.type;
	
    if (currentType != nil) {
		NSInteger index = [recipeTypes indexOfObject:currentType];
		NSIndexPath *selectionIndexPath = [NSIndexPath indexPathForRow:index inSection:0];
        UITableViewCell *checkedCell = [tableView cellForRowAtIndexPath:selectionIndexPath];
        checkedCell.accessoryType = UITableViewCellAccessoryNone;
    }
    
    // Set the checkmark accessory for the selected row.
    [[tableView cellForRowAtIndexPath:indexPath] setAccessoryType:UITableViewCellAccessoryCheckmark];    
    
    // Update the type of the recipe instance
    recipe.type = [recipeTypes objectAtIndex:indexPath.row];
    
    // Deselect the row.
    [tableView deselectRowAtIndexPath:indexPath animated:YES];*/
    
}


- (void)dealloc {
    [rolTypes release];
    [super dealloc];
}


@end
