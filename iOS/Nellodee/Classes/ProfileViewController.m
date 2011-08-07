//
//  ProfileViewController.m
//  Nellodee
//
//  Created by Ada Hopper on 26/07/11.
//  Copyright 2011 __MyCompanyName__. All rights reserved.
//

#import "ProfileViewController.h"
#import "BasicProfileViewController.h"
#import "AboutViewController.h"
#import "MeService.h"
#import "TagsViewController.h"

@implementation ProfileViewController

@synthesize options;


#define BASIC 0
#define ABOUT 1
#define CATEGORIES 2
#define PUBLICATIONS 3

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
    return cell;
}

#pragma mark - Table view delegate

- (void)tableView:(UITableView *)tableView didSelectRowAtIndexPath:(NSIndexPath *)indexPath {
    
    MeService *me =[[MeService alloc] init];
    [me meService];
    
    if([indexPath row] == BASIC){
    
        BasicProfileViewController *profileView = [[BasicProfileViewController alloc] initWithStyle:UITableViewStyleGrouped];
        
        // Push the detail view controller.
        [[self navigationController] pushViewController:profileView animated:YES];
        [profileView release];
        

        
    }
    else if ([indexPath row] == ABOUT){
        AboutViewController *aboutView = [[AboutViewController alloc] initWithStyle:UITableViewStyleGrouped];
        
        // Push the detail view controller.
        [[self navigationController] pushViewController:aboutView animated:YES];
        [aboutView release];

        
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

/*

- (void)tableView:(UITableView *)tableView didSelectRowAtIndexPath:(NSIndexPath *)indexPath {
    if([indexPath row] == BASIC){
        [[NSNotificationCenter defaultCenter] addObserver:self
                                              selector:@selector(loadBasicProfileView:) 
                                              name:@"meServiceNotification"
                                              object:nil];
    }
    else if([indexPath row] == ABOUT){
        [[NSNotificationCenter defaultCenter] addObserver:self
                                                 selector:@selector(loadAboutMeView:) 
                                                     name:@"meServiceNotification"
                                                   object:nil];
        
    }
    
    MeService *me =[[MeService alloc] init];
    [me meService];

    

}*/


/*- (void) loadBasicProfileView:(NSNotification *) notification{

    
    if ([[notification name] isEqualToString:@"meServiceNotification"]){
        NSLog (@"Successfully received the test notification!");

        //NSString  *nombre = [[[NellodeeApp sharedNellodeeData] basicInfo] firstName];
        

        //BasicProfileViewController *basicProfileView =[[BasicProfileViewController alloc] initWithStyle:UITableViewStyleGrouped];
        // [self.navigationController pushViewController:basicProfileView animated:NO];
        */
        /*UIViewController *nextCntlr;
        
        nextCntlr = [[BasicProfileViewController alloc] initWithStyle:UITableViewStyleGrouped];
        nextCntlr.title = @"Basic Profile";
        [[self navigationController] pushViewController:nextCntlr animated:YES];
        
          
        UIViewController *topVC = (UIViewController *)self.navigationController.delegate;
        [topVC.navigationController pushViewController:nextCntlr animated:YES];
        [nextCntlr release];*/
    
/*    }
}
- (void) loadAboutMeView:(NSNotification *) notification{
    
    
    if ([[notification name] isEqualToString:@"meServiceNotification"]){
        NSLog (@"[ABOUT VIEW] Successfully received the test notification! ");
        AboutViewController *aboutView =[[AboutViewController alloc] initWithStyle:UITableViewStyleGrouped];
        [self.navigationController pushViewController:aboutView animated:NO];
        */
        /*UIViewController *nextCntlr;
        
        nextCntlr = [[AboutViewController alloc] initWithStyle:UITableViewStyleGrouped];
        nextCntlr.title = @"About me";
        [[self navigationController] pushViewController:nextCntlr animated:YES];
        
        UIViewController *topVC = (UIViewController *)self.navigationController.delegate;
        [topVC.navigationController pushViewController:nextCntlr animated:YES];
        [nextCntlr release];*/
        
//    }
//}



@end
