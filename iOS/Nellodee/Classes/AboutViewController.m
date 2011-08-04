//
//  AboutViewController.m
//  Nellodee
//
//  Created by Ada Hopper on 04/08/11.
//  Copyright 2011 __MyCompanyName__. All rights reserved.
//

#import "AboutViewController.h"
#import "NellodeeApp.h"

@implementation AboutViewController
@synthesize about;

#define ME 0
#define ACADEMIC 1
#define PERSONAL 2
#define HOBBIES 3


#pragma mark -
#pragma mark View lifecycle


- (void)viewWillAppear:(BOOL)animated {
    
    //Get user information
    //about = [[NellodeeApp sharedNellodeeData] about] ; 
    
    self.navigationItem.rightBarButtonItem = self.editButtonItem;
    
    // Update the view with current data before it is displayed.
    [super viewWillAppear:animated];
    
    // Scroll the table view to the top before it appears  
    [self.tableView setContentOffset:CGPointZero animated:YES];
    self.title = @"About Me";
    
    
}


#pragma mark -
#pragma mark Table view data source

- (NSInteger)numberOfSectionsInTableView:(UITableView *)tableView {
    // There are three sections, for rol, college info, and tags, in that order.
    return 4;
}


- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section {
    
    return 1;
    
}


- (NSString *)tableView:(UITableView *)tableView titleForHeaderInSection:(NSInteger)section {
    NSString *title = nil;
    // Return a title or nil as appropriate for the section.
    switch (section) {
        case ME:
            title = @"About me";
            break;
        case ACADEMIC:
            title = @"Academic Interests";
            break;
        case PERSONAL:
            title = @"Personal Interests";
            break;
        case HOBBIES:
            title = @"Hobbies";
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
        case ME: 
            cell.textLabel.text = @"me";
            cell.accessoryType = UITableViewCellAccessoryNone;
            cell.editingAccessoryType = UITableViewCellAccessoryDisclosureIndicator;
            break;
            
        case ACADEMIC: 
            cell.textLabel.text = @"academic";
            cell.accessoryType = UITableViewCellAccessoryNone;
            cell.editingAccessoryType = UITableViewCellAccessoryDisclosureIndicator;
            break;
            
        case PERSONAL: 
            cell.textLabel.text = @"me";
            cell.accessoryType = UITableViewCellAccessoryNone;
            cell.editingAccessoryType = UITableViewCellAccessoryDisclosureIndicator;
            break;
            
        case HOBBIES:
            cell.textLabel.text = @"hobbies";
            cell.accessoryType = UITableViewCellAccessoryNone;
            cell.editingAccessoryType = UITableViewCellAccessoryDisclosureIndicator;
            break;
            
        default:
            break;
    }
    return cell;
    
    
}

- (void)tableView:(UITableView *)tableView didSelectRowAtIndexPath:(NSIndexPath *)indexPath {
    

}





@end