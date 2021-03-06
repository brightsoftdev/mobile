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
@class AboutMeWS;
@class CategoriesWS;

@interface ProfileViewController : UITableViewController <UITableViewDataSource,UITabBarDelegate>{
    NSMutableArray * options;
	BasicInfoWS *basicInfoWS;
	AboutMeWS *aboutMeWS;
	CategoriesWS *categoriesWS;
}

@property (nonatomic, retain) NSMutableArray * options;
@property (nonatomic, retain) BasicInfoWS *basicInfoWS;
@property (nonatomic, retain) AboutMeWS *aboutMeWS;
@property (nonatomic, retain) CategoriesWS *categoriesWS;
@end
