//
//  UserViewController.h
//  Nellodee
//
//  Created by Ada Hopper on 24/07/11.
//  Copyright 2011 __MyCompanyName__. All rights reserved.
//

#import <UIKit/UIKit.h>


@interface UserViewController : UITableViewController  <UITableViewDataSource,UITabBarDelegate>{
    NSMutableArray * options;
    UINavigationController *profileNavController;

}

-(id) init;
@property (nonatomic,retain) NSMutableArray * options;
@property (nonatomic, retain) UINavigationController *profileNavController;

@end
