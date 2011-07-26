//
//  ProfileViewController.h
//  Nellodee
//
//  Created by Ada Hopper on 26/07/11.
//  Copyright 2011 __MyCompanyName__. All rights reserved.
//

#import <UIKit/UIKit.h>


@interface ProfileViewController : UITableViewController <UITableViewDataSource,UITabBarDelegate>{
    NSMutableArray * options;
}

@property (nonatomic, retain) NSMutableArray * options;

@end
