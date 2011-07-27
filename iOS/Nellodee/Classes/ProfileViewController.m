//
//  ProfileViewController.m
//  Nellodee
//
//  Created by Ada Hopper on 26/07/11.
//  Copyright 2011 __MyCompanyName__. All rights reserved.
//

#import "ProfileViewController.h"
#import "BasicProfileViewController.h"

@implementation ProfileViewController

@synthesize options;

+ (NSArray *) defaultOptions{
    return [NSArray arrayWithObjects:@"Basic Information", @"About me", @"Categories", @"Publications",nil];
}


#pragma mark -
#pragma mark View lifecycle


- (void)viewWillAppear:(BOOL)animated {
    if (self != nil){
        self->options = [[[self class] defaultOptions] mutableCopy];
        assert(self->options !=nil);
    }
    // Update the view with current data before it is displayed.
    [super viewWillAppear:animated];
    
    // Scroll the table view to the top before it appears
    [self.tableView reloadData];
    [self.tableView setContentOffset:CGPointZero animated:YES];
    self.title = @"Profile";
}

- (UITableViewCellAccessoryType)tableView:(UITableView *)tv accessoryTypeForRowWithIndexPath:(NSIndexPath *)indexPath{
    
    return UITableViewCellAccessoryDisclosureIndicator;
}

#pragma mark -
#pragma mark Table view data source

- (NSInteger)numberOfSectionsInTableView:(UITableView *)tableView {
    // There are three sections, for date, genre, and characters, in that order.
    return 1;
}


- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section {
    
    return [options count];
}


- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath {
    

	static NSString *CellIdentifier = @"CellIdentifier";
    
    UITableViewCell *cell = [tableView dequeueReusableCellWithIdentifier:CellIdentifier];
    if (cell == nil) {
        cell = [[[UITableViewCell alloc] initWithStyle:UITableViewCellStyleDefault reuseIdentifier:CellIdentifier] autorelease];
    }
    
    
    cell.textLabel.text = [[self.options objectAtIndex:indexPath.row] description];
	//cell.textLabel.text =@"Celda";
    return cell;
}

- (void)tableView:(UITableView *)tableView didSelectRowAtIndexPath:(NSIndexPath *)indexPath {
        
    
    
    UIViewController *nextCntlr;

    nextCntlr = [[BasicProfileViewController alloc] init];
    nextCntlr.title = @"Basic Profile";
    [[self navigationController] pushViewController:nextCntlr animated:YES];
    
    // THIS IS THE MAGIC PART 2
    UIViewController *topVC = (UIViewController *)self.navigationController.delegate;
	[topVC.navigationController pushViewController:nextCntlr animated:YES];
	[nextCntlr release];
}





@end
