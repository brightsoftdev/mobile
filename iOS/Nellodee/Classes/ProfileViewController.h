//
//  ProfileViewController.h
//  Nellodee
//
//  Created by Ada Hopper on 26/07/11.
//  Copyright 2011 __MyCompanyName__. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "NellodeeApp.h"

@class BasicInfoWS;

@interface ProfileViewController : UITableViewController <UITableViewDataSource,UITabBarDelegate>{
    NSMutableArray * options;
	BasicInfoWS *basicInfoWS;
}

@property (nonatomic, retain) NSMutableArray * options;
@property (nonatomic, retain) BasicInfoWS *basicInfoWS;

@end
